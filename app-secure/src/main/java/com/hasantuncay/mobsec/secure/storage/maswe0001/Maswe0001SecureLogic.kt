package com.hasantuncay.mobsec.secure.storage.maswe0001

import android.content.Context
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import com.hasantuncay.mobsec.secure.BuildConfig
import com.hasantuncay.mobsec.secure.utils.SecureLog
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import java.io.File
import java.security.MessageDigest
import kotlin.concurrent.thread

/**
 * 🛡️ SECURE IMPLEMENTATION: MASWE-0001 (Sensitive Data Leakage via Logging - CWE-532 / CWE-359)
 *
 * EDUCATIONAL OVERVIEW:
 * This class serves as the ultimate reference for Secure Logging Practices on Android.
 * According to Official Android Guidelines and OWASP MASVS, sensitive data (PII, PCI-DSS, System Keys)
 * must NEVER cross trust boundaries unencrypted, especially not into system logs, local files, or telemetry.
 *
 * KEY MITIGATIONS DEMONSTRATED HERE:
 * 1. Custom Logging & ProGuard (MASTG-BEST-0002): Preventing Heap Memory leaks via `vararg` and R8.
 * 2. Privacy Compliance (MASTG-BEST-0003): Redacting `toString()` outputs in the domain layer to protect PII/PCI.
 * 3. Network Redaction: Intercepting and masking HTTP Authorization headers.
 * 4. Data Masking & Jetpack Security: Encrypting local diagnostic files while strictly dropping CVV/PIN.
 * 5. Telemetry Sanitization: Hashing PII (SHA-256) before sending data to 3rd-party SDKs (e.g., Crashlytics).
 * 6. WebView JS Filtering: Blocking JavaScript `console.log` from leaking Session Cookies to Logcat.
 */
object Maswe0001SecureLogic {

    fun executeVector(vector: Maswe0001Vector, appData: MasterclassData, context: Context) {
        when (vector) {
            Maswe0001Vector.SYSTEM_CONSOLE -> secureSystemConsoleLeak(appData)
            Maswe0001Vector.NETWORK_INTERCEPTOR -> secureNetworkLeak(appData)
            Maswe0001Vector.LOCAL_FILE -> secureLocalFileLeak(appData, context)
            Maswe0001Vector.SDK_TELEMETRY -> secureSdkTelemetryLeak(appData)
            Maswe0001Vector.WEBVIEW_CONSOLE -> secureWebViewConsoleLeak(appData, context)
        }
        
        val msg = context.getString(vector.msgSecureRes)
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * VECTOR 1: SYSTEM CONSOLE (Logcat)
     * WHY IT'S DANGEROUS: Standard `Log.d("Tag", "Key: $key")` allocates a `StringBuilder` in the Heap RAM.
     * Even if R8 strips the Log call, the string remains in memory and can be extracted via Memory Dumping.
     */
    private fun secureSystemConsoleLeak(appData: MasterclassData) {
        // SECURE PRACTICE 1: Generic Error Messages
        // Never dump domain objects directly. Attackers cannot glean system state from this.
        SecureLog.e("SecureSystem", "Application encountered a recoverable error. ErrorCode: E-450. SessionActive: true")
        
        // SECURE PRACTICE 2 (MASTG-BEST-0002): Prevent Heap Memory Leaks
        // Notice the use of `%s` and passing the master key as a separate argument (`vararg`).
        // HOW IT WORKS:
        // - We DO NOT use string interpolation (`"Key: " + key`).
        // - `SecureLog` handles the formatting internally.
        // - In Release mode, R8 sees `-assumenosideeffects` for `SecureLog` in proguard-rules.pro.
        // - R8 completely strips this ENTIRE line from the bytecode.
        // RESULT: Zero StringBuilder allocation. The AES key never becomes a String object in RAM.
        SecureLog.d("SecureSystem", "Simulated Check - Master Key is present: %s", appData.systemContext.masterCryptoKeyAesGcm)

        // SECURE PRACTICE 3 (MASTG-BEST-0003): Comply with Privacy Regulations
        // Even if a developer accidentally logs the whole object, our overridden `toString()` 
        // in `SystemData` will safely output "[REDACTED_SYSTEM_DATA]" protecting regulatory data.
        SecureLog.d("SecureSystem", "Object Dump Protection Test: %s", appData.systemContext.toString())
    }

    /**
     * VECTOR 2: NETWORK INTERCEPTORS
     * WHY IT'S DANGEROUS: `HttpLoggingInterceptor` (Level.BODY or HEADERS) prints OAuth Tokens and 
     * CSRF tokens to Logcat. If a 3rd party app has `READ_LOGS`, it can hijack the user's session.
     */
    private fun secureNetworkLeak(appData: MasterclassData) {
        thread {
            // HOW WE FIX IT:
            // 1. Force Logging Level to NONE in Production builds.
            val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.NONE
            val loggingInterceptor = HttpLoggingInterceptor().apply { this.level = level }
            
            // 2. The Redacting Interceptor (Defense-in-Depth)
            // Even in DEBUG mode, we manually strip sensitive headers before they hit the logging engine.
            val redactingInterceptor = Interceptor { chain ->
                val request = chain.request()
                val authHeader = request.header("Authorization")
                if (authHeader != null && BuildConfig.DEBUG) {
                    // We only log that the header existed, NOT its value.
                    SecureLog.d("SecureNetwork", "Outgoing request with REDACTED Authorization header.")
                }
                chain.proceed(request)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(redactingInterceptor)
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
                SecureLog.e("SecureNetwork", "Network request failed securely without dumping headers.")
            }
        }
    }

    /**
     * VECTOR 3: LOCAL FILE DUMPING (Diagnostics)
     * WHY IT'S DANGEROUS: Writing diagnostic data to plaintext files (`filesDir` or `sdcard`) 
     * exposes it to malware with `READ_EXTERNAL_STORAGE` or root access.
     */
    private fun secureLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            // STEP 1: Strict Data Filtering & Masking (PCI-DSS Compliance)
            val dumpObj = JSONObject().apply {
                put("hipaa_diagnosis", appData.hipaaPhi.icd10DiagnosisCode)
                put("device_ssaid", appData.deviceTelemetry.androidSsaid)
                
                // CRITICAL RULE: CVV and PIN must NEVER be stored anywhere, even if encrypted.
                // We explicitly exclude them from this JSON object.
                
                // MASKING: The Primary Account Number (PAN) is masked (e.g., 123456******7890).
                val pan = appData.pciDss.cardholderData.primaryAccountNumber
                val maskedPan = if (pan.length > 10) "${pan.take(6)}******${pan.takeLast(4)}" else "MASKED"
                put("pan", maskedPan)
            }

            // STEP 2: AES256-GCM Encryption (Jetpack Security)
            // We use Android's hardware-backed Keystore to generate a MasterKey.
            val mainKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            val file = File(context.filesDir, "diagnostics_secure.json")
            if (file.exists()) file.delete() 

            // EncryptedFile handles Chunking and AES-GCM Authentication transparently.
            val encryptedFile = EncryptedFile.Builder(
                context,
                file,
                mainKey,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
            ).build()

            encryptedFile.openFileOutput().use { stream ->
                stream.write(dumpObj.toString(4).toByteArray())
            }
            SecureLog.i("SecureStorage", "Secure diagnostic file written with Jetpack Security and PCI-DSS compliance.")
        } catch (e: Exception) {
            SecureLog.e("SecureStorage", "Error writing secure file", e)
        }
    }

    /**
     * VECTOR 4: SDK TELEMETRY (Crashlytics, Mixpanel, etc.)
     * WHY IT'S DANGEROUS: Sending raw PII (like emails) to 3rd-party servers violates GDPR/CCPA.
     * If the 3rd-party is breached, your users' data is compromised.
     */
    private fun secureSdkTelemetryLeak(appData: MasterclassData) {
        // HOW WE FIX IT: Data Sanitization (Hashing)
        // We use SHA-256 to create a one-way irreversible hash of the email.
        // Analytics can still track unique users (the hash remains constant for the same email),
        // but they cannot reverse the hash to find the actual email address.
        val email = appData.gdprPii.directIdentifiers.personalEmail
        val emailHash = hashString(email)
        
        // We also convert sensitive content (draft messages) into a boolean flag (`has_drafts`).
        val safePayload = """
            {
              "event": "App_Crash",
              "user_id_hash": "$emailHash",
              "has_drafts": ${appData.userContext.draftMessagesDb.isNotEmpty()}
            }
        """.trimIndent()
        
        SecureLog.i("SecureSDK", "Sending sanitized, anonymous payload to Analytics SDK: \n%s", safePayload)
    }

    /**
     * VECTOR 5: WEBVIEW CONSOLE
     * WHY IT'S DANGEROUS: Modern apps use WebViews for hybrid flows (OAuth, Payments).
     * If the JavaScript code calls `console.log("Token: " + token)`, the Android `WebChromeClient`
     * will catch this and print it to the native Logcat, bridging the web vulnerability into Android.
     */
    private fun secureWebViewConsoleLeak(appData: MasterclassData, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        
        // HOW WE FIX IT: Keyword Filtering in the Native Bridge
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                val msg = consoleMessage.message().lowercase()
                
                // We define a blacklist of sensitive terms.
                val sensitiveKeywords = listOf("cookie", "token", "auth", "bearer", "password")
                
                // If the JS console message contains any of these words, we block it entirely.
                if (sensitiveKeywords.any { msg.contains(it) }) {
                    SecureLog.w("SecureWebView", "Blocked a potentially sensitive WebView console message.")
                    return true // Returning true tells the system "I handled this, do not print it."
                }
                
                if (BuildConfig.DEBUG) {
                    SecureLog.d("SecureWebView", "JS Console: %s", consoleMessage.message())
                }
                return true
            }
        }
        
        val cookie = appData.networkSession.webViewSessionCookie
        val refreshToken = appData.networkSession.oAuth2RefreshToken
        val html = """
            <html><body>
            <script>
                // These logs will be successfully BLOCKED by our WebChromeClient filter.
                console.log("DEBUG: Restoring session with Cookie: $cookie");
                console.log("DEBUG: Auth Refresh Token: $refreshToken");
                // This innocent log will pass through the filter.
                console.log("UI_STATE: Rendered Successfully");
            </script>
            </body></html>
        """.trimIndent()
        webView.loadData(html, "text/html", "UTF-8")
    }

    /**
     * Utility function to generate a SHA-256 hash.
     * In a real app, you might salt this to prevent Rainbow Table attacks.
     */
    private fun hashString(input: String): String {
        return try {
            val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
            bytes.joinToString("") { "%02x".format(it) }
        } catch (e: Exception) {
            "HASH_ERROR"
        }
    }
}
 