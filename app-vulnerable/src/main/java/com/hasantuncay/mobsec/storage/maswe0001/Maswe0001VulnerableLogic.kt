package com.hasantuncay.mobsec.storage.maswe0001

import android.content.Context
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import kotlin.concurrent.thread

/**
 * ⚠️ VULNERABLE IMPLEMENTATION: MASWE-0001 (Log Info Disclosure)
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
object Maswe0001VulnerableLogic {

    fun executeVector(vector: Maswe0001Vector, appData: MasterclassData, context: Context) {
        when (vector) {
            Maswe0001Vector.SYSTEM_CONSOLE -> triggerSystemConsoleLeak(appData)
            Maswe0001Vector.NETWORK_INTERCEPTOR -> triggerNetworkLeak(appData)
            Maswe0001Vector.LOCAL_FILE -> triggerLocalFileLeak(appData, context)
            Maswe0001Vector.SDK_TELEMETRY -> triggerSdkTelemetryLeak(appData)
            Maswe0001Vector.WEBVIEW_CONSOLE -> triggerWebViewConsoleLeak(appData, context)
        }
        
        val msg = context.getString(vector.msgVulnRes)
        if (vector == Maswe0001Vector.LOCAL_FILE) {
            val file = File(context.filesDir, "diagnostics_vulnerable.json")
            Toast.makeText(context, String.format(msg, file.absolutePath), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
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
            TCKN: ${appData.gdprPii.directIdentifiers.nationalIdentificationNumber.getDataToMask()}
            Email: ${appData.gdprPii.directIdentifiers.personalEmail.getDataToMask()}
            
            [User Data]
            Password (Plain): ${appData.userContext.plainTextPasswordInHeap}
            --------------------------------
        """.trimIndent()
        Log.e("VULN_APP_TAG", dump)
    }

    /**
     * VULNERABLE VECTOR 2: NETWORK INTERCEPTORS (CWE-532 / CWE-117)
     * Mechanism: Instantiates OkHttp `HttpLoggingInterceptor` with `Level.BODY` and applies
     * a custom interceptor that explicitly logs the `Request.headers`.
     * Impact: OAuth2 Bearer tokens and CSRF parameters are logged in plaintext. Replay attacks
     * and session hijacking become viable if logs are exfiltrated.
     */
    private fun triggerNetworkLeak(appData: MasterclassData) {
        thread {
            val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val headerDumpInterceptor = Interceptor { chain ->
                val request = chain.request()
                Log.e("VULN_NETWORK", "Outgoing Request Headers: \n${request.headers}")
                chain.proceed(request)
            }
            
            val client = OkHttpClient.Builder()
                .addInterceptor(headerDumpInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
                
            val token = appData.networkSession.oAuth2BearerToken
            val endpoint = appData.systemContext.backendGraphqlEndpoint
            val request = Request.Builder()
                .url(endpoint)
                .header("Authorization", "Bearer $token")
                .header("X-CSRF-Token", appData.networkSession.csrfToken)
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                Log.e("VULN_APP_TAG", "Network error (simulated) on $endpoint")
            }
        }
    }

    /**
     * VULNERABLE VECTOR 3: LOCAL FILE DUMPING (CWE-312 / PCI-DSS Non-Compliance)
     * Mechanism: Serializes domain objects into a JSON payload and writes them via `FileOutputStream`
     * to the internal `filesDir` without hardware-backed cryptographic protection (AES-GCM).
     * Impact: CVV and PIN Block storage is a strict violation of PCI-DSS Requirement 3.2. 
     * Plaintext storage allows extraction via rooted physical access or arbitrary read vulnerabilities.
     */
    private fun triggerLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            val file = File(context.filesDir, "diagnostics_vulnerable.json")
            FileOutputStream(file, false).use { stream ->
                val dumpObj = JSONObject().apply {
                    put("pan", appData.pciDss.cardholderData.primaryAccountNumber)
                    put("cvv", appData.pciDss.sensitiveAuthenticationData.cardVerificationCode) // SEVERE PCI-DSS VIOLATION
                    put("pinBlock", appData.pciDss.sensitiveAuthenticationData.pinBlock) // SEVERE PCI-DSS VIOLATION
                    put("hipaa_mrn", appData.hipaaPhi.medicalRecordNumber)
                    put("hipaa_diagnosis", appData.hipaaPhi.icd10DiagnosisCode)
                    put("device_ssaid", appData.deviceTelemetry.androidSsaid)
                }
                stream.write(dumpObj.toString(4).toByteArray())
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
              "user_email": "${appData.gdprPii.directIdentifiers.personalEmail.getDataToMask()}",
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
    private fun triggerWebViewConsoleLeak(appData: MasterclassData, context: Context) {
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
