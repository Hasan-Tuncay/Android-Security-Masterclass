package com.hasantuncay.mobsec.maswe0005.vulnerable

import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Mitigation
import com.hasantuncay.mobsec.maswe0005.R
import com.hasantuncay.mobsec.common.R as CommonR

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileOutputStream
import com.hasantuncay.mobsec.common.models.data.MasterclassData

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0005 (Log Info Disclosure)
 *
 * TECHNICAL OVERVIEW:
 * This class isolates intentional security anti-patterns resulting in data leakage.
 * All vectors demonstrated herein violate OWASP MASVS-STORAGE and MASVS-CODE standards.
 * The primary vulnerability class is CWE-532 (Information Exposure Through Log Files)
 * and CWE-312 (Cleartext Storage of Sensitive Information).
 *
 * VULNERABILITY VECTORS:
 * 1. SYSTEM CONSOLE: Direct plaintext dumping of cryptographic keys and PII.
 * 2. NETWORK INTERCEPTOR: Exposure of Authorization and CSRF headers via OkHttp loggers.
 * 3. LOCAL FILE: Storage of prohibited PCI-DSS data (CVV, PIN) in unencrypted local files.
 * 4. SDK TELEMETRY: Transmission of unhashed PII to third-party SDK simulation.
 * 5. WEBVIEW CONSOLE: Bridging DOM-level JavaScript logs to the native Android Logcat.
 */
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.Context

@Singleton
class Maswe0005VulnerableRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun executeVector(
        vector: Maswe0005Vector,
        appData: MasterclassData
    ): String? {
        when (vector) {
            Maswe0005Vector.SYSTEM_CONSOLE -> triggerSystemConsoleLeak(appData)
            Maswe0005Vector.NETWORK_INTERCEPTOR -> triggerNetworkLeak(appData)
            Maswe0005Vector.LOCAL_FILE -> triggerLocalFileLeak(appData)
            Maswe0005Vector.SDK_TELEMETRY -> triggerSdkTelemetryLeak(appData)
            Maswe0005Vector.WEBVIEW_CONSOLE -> triggerWebViewConsoleLeak(appData)
        }

        // Auto-launch Attacker App for Logcat Snooping
        val exploitIntent = android.content.Intent().apply {
            action = "com.hasantuncay.mobsec.attacker.action.LOGCAT"
            setClassName("com.hasantuncay.mobsec.attacker", "com.hasantuncay.mobsec.attacker.AttackerMainActivity")
            addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        try {
            context.startActivity(exploitIntent)
        } catch (e: android.content.ActivityNotFoundException) {
            Log.w("VULN_0005", "Attacker app not installed.")
            android.os.Handler(android.os.Looper.getMainLooper()).post {
                Toast.makeText(context, context.getString(CommonR.string.error_attacker_app_not_installed), Toast.LENGTH_LONG).show()
            }
        }
        
        if (vector == Maswe0005Vector.LOCAL_FILE) {
            val file = File(context.filesDir, "app_debug.log")
            return file.absolutePath
        } else {
            val tag = when(vector) {
                Maswe0005Vector.SYSTEM_CONSOLE -> "VULN_APP_TAG"
                Maswe0005Vector.NETWORK_INTERCEPTOR -> "VULN_NETWORK"
                Maswe0005Vector.SDK_TELEMETRY -> "VULN_SDK_SIMULATION"
                Maswe0005Vector.WEBVIEW_CONSOLE -> "VULN_WEBVIEW"
                else -> null
            }
            return tag
        }
    }

    /**
     * VULNERABLE VECTOR 1: SYSTEM CONSOLE (CWE-532)
     * Mechanism: Utilizes string interpolation to allocate sensitive data in the Heap (StringBuilder)
     * and writes the payload to the system-wide Logcat buffer (`/dev/log/main`).
     * Impact: Any malware with root privileges, adb access, or system-level `READ_LOGS` permission
     * can extract cryptographic keys (AES/RSA) and plaintext passwords.
     */
    private fun triggerSystemConsoleLeak(appData: MasterclassData) {
        val dump = """
            
            --- CRITICAL APP STATE DUMP ---
            [System Data] 
            Master Key: ${appData.systemContext.masterCryptoKeyAesGcm}
            RSA Private: ${appData.systemContext.rsaPrivateKeyPem.take(30)}...
            
            [GDPR PII Data]
            Name: ${appData.gdprPii.directIdentifiers.fullName}
            TCKN: ${String(appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask())}
            Email: ${String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask())}
            
            [User Data]
            Password (Plain): ${appData.userContext.plainTextPasswordInHeap}
            --------------------------------
        """.trimIndent()
        Log.e("VULN_APP_TAG", dump)
    }

    /**
     * VULNERABLE VECTOR 2: NETWORK INTERCEPTORS (CWE-532 / CWE-117)
     * Mechanism: Instantiates OkHttp `HttpLoggingInterceptor` with `Level.BODY`
     * Impact: OAuth2 Bearer tokens and CSRF parameters are logged in plaintext. Replay attacks
     * and session hijacking become viable if logs are exfiltrated.
     */
    private fun triggerNetworkLeak(appData: MasterclassData) {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
            
        val token = appData.networkSession.oAuth2BearerToken
        val endpoint = appData.systemContext.backendGraphqlEndpoint
        val request = Request.Builder()
            .url(endpoint)
            .header("Authorization", "Bearer $token")
            .header("X-CSRF-Token", appData.networkSession.csrfToken)
            .build()
            
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                Log.e("VULN_APP_TAG", "Network error (simulated) on $endpoint")
            }
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                // Ignored response for demonstration
            }
        })
    }

    /**
     * VULNERABLE VECTOR 3: CUSTOM FILE LOGGER (CWE-532 / PCI-DSS Non-Compliance)
     * Mechanism: Simulates a custom file-based logger (e.g., rolling file appender) that writes
     * application state and diagnostics to a local .log file in append mode.
     * Impact: Plaintext storage allows extraction via rooted physical access or arbitrary read vulnerabilities.
     */
    private fun triggerLocalFileLeak(appData: MasterclassData) {
        try {
            val file = File(context.filesDir, "app_debug.log")
            FileOutputStream(file, true).use { stream ->
                val timestamp = System.currentTimeMillis()
                val threadName = Thread.currentThread().name
                val logLine = "[ERROR] [$timestamp] [$threadName] Payment processing failed. " +
                              "Diagnostic Dump -> PAN: ${appData.pciDss.cardholderData.primaryAccountNumber}, " +
                              "CVV: ${appData.pciDss.sensitiveAuthenticationData.cardVerificationCode}\n"
                stream.write(logLine.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * VULNERABLE VECTOR 4: SDK TELEMETRY (CWE-359)
     * Mechanism: Aggregates unhashed PII and arbitrary system metrics (Clipboard, SIM ICCID)
     * into a JSON string representing a third-party crash report payload.
     * Impact: Transmitting raw PII to external analytics servers violates GDPR principles of 
     * Data Minimization and subjects the data to third-party infrastructure risks.
     */
    private fun triggerSdkTelemetryLeak(appData: MasterclassData) {
        val payload = """
            {
              "event": "App_Crash",
              "user_email": "${String(appData.gdprPii.directIdentifiers.personalEmail.getDataToMask())}",
              "clipboard": "${appData.userContext.clipboardCache}",
              "draft_messages": ${appData.userContext.draftMessagesDb},
              "sim_iccid": "${appData.deviceTelemetry.simCardIccid}"
            }
        """.trimIndent()
        Log.e("VULN_SDK_SIMULATION", "Sending Crashlytics Payload: \n$payload")
    }

    /**
     * VULNERABLE VECTOR 5: WEBVIEW CONSOLE BRIDGE (CWE-532)
     * Mechanism: Implements a `WebChromeClient` that routes `onConsoleMessage` directly to `Log.e`.
     * Impact: Any sensitive data logged by the web application's JavaScript context (e.g., Session 
     * Cookies, Refresh Tokens) automatically leaks into the native Android system logs.
     */
    private fun triggerWebViewConsoleLeak(appData: MasterclassData) {
        android.os.Handler(android.os.Looper.getMainLooper()).post {
            val webView = WebView(context)
            webView.settings.javaScriptEnabled = true
            webView.webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                    Log.e("VULN_WEBVIEW", "JS Console: " + consoleMessage.message())
                    return true
                }
            }
            val cookie = appData.networkSession.webViewSessionCookie
            val refreshToken = appData.networkSession.oAuth2RefreshToken
            val html = """
                <html><body>
                <script>
                    console.log("DEBUG: Restoring session with Cookie: $cookie");
                    console.log("DEBUG: Auth Refresh Token: $refreshToken");
                </script>
                </body></html>
            """.trimIndent()
            webView.loadData(html, "text/html", "UTF-8")
        }
    }
}
