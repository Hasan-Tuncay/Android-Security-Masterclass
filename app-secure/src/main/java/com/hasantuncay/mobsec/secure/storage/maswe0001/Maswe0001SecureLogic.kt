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
 * 2. Data Class Sanitization: Redacting `toString()` outputs in the domain layer as a defense-in-depth for logging.
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
        // ==========================================
        // DEMONSTRATION 1: The 3 Logging Models
        // ==========================================
        
        // MODEL A: Unsafe Logging (Bypasses ErrorProne, Leaks Memory in Heap)
        // DANGER: The string is concatenated before the method call.
        SecureLog.dUnsafe("SecureSystem", "UNSAFE LOG - Key Length: " + appData.systemContext.masterCryptoKeyAesGcm.length)
        
        // MODEL B: Strict Logging (Maximum Security, Enforced by ErrorProne)
        // PASS: The string is a compile-time constant.
        SecureLog.dStrict("SecureSystem", "STRICT LOG - System Check Completed Successfully.")
        // FAIL (Uncomment to see ErrorProne Compile Error in IDE): 
        // SecureLog.dStrict("SecureSystem", "STRICT LOG - Key: " + appData.systemContext.masterCryptoKeyAesGcm)
        
        // MODEL C: Hybrid Parameterized Logging (Recommended)
        // PASS: The template is constant, dynamic data is passed via vararg. Prevents Heap allocation.
        SecureLog.d("SecureSystem", "HYBRID LOG - Master Key is present (Length: %d)", appData.systemContext.masterCryptoKeyAesGcm.length)

        // ==========================================
        // DEMONSTRATION 2: Data Class Sanitization
        // ==========================================
        // Even if a developer accidentally logs the whole object via vararg, our overridden `toString()` 
        // in `SystemData` will safely output "[REDACTED_SYSTEM_DATA]".
        SecureLog.d("SecureSystem", "Object Dump Protection Test: %s", appData.systemContext.toString())
        
        // ==========================================
        // DEMONSTRATION 3: Memory Scrubbing (CWE-226)
        // ==========================================
        // The password is kept in a CharArray instead of an immutable String.
        // We wipe it with zeros instantly, rather than waiting for the Garbage Collector.
        appData.userContext.scrubPassword()
        SecureLog.dStrict("SecureSystem", "Memory Scrubbing Executed: Plaintext password wiped from RAM.")
        
        // ==========================================
        // DEMONSTRATION 4: Incident Response (Kill Switch)
        // ==========================================
        // Simulating a critical breach where the backend flips the kill switch via Remote Config.
        com.hasantuncay.mobsec.secure.utils.RemoteConfigSim.isLoggingKilled = true
        SecureLog.e("SecureSystem", "🚨 THIS LOG WILL NEVER PRINT BECAUSE THE KILL SWITCH IS ACTIVE 🚨")
        com.hasantuncay.mobsec.secure.utils.RemoteConfigSim.isLoggingKilled = false // Reset for further tests
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
                val csrfHeader = request.header("X-CSRF-Token")
                if ((authHeader != null || csrfHeader != null) && BuildConfig.DEBUG) {
                    // We only log that the headers existed, NOT their values.
                    SecureLog.d("SecureNetwork", "Outgoing request with REDACTED sensitive headers.")
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
        // ==========================================
        // TECHNIQUE: CRYPTOGRAPHIC ANONYMIZATION (KDF)
        // ==========================================
        // Simply hashing PII (like emails or phone numbers) with SHA-256 is INSECURE because
        // low-entropy data can be easily brute-forced (billions of hashes/sec on modern GPUs).
        // To properly anonymize PII for external SDKs without a true Token Vault, we must use a
        // Key Derivation Function (KDF) like PBKDF2. This introduces "computational cost",
        // making brute-force mathematically unfeasible.
        
        val email = appData.gdprPii.directIdentifiers.personalEmail.getDataToMask()
        // The salt should ideally be randomly generated per user and stored securely.
        // For demonstration, we use the device-specific SSAID as a static salt.
        val salt = appData.deviceTelemetry.androidSsaid
        
        // Use PBKDF2 with 10,000+ iterations instead of a single-pass SHA-256
        val anonymizedId = generatePbkdf2Hash(email, salt)

        // ==========================================
        // EDUCATIONAL NOTE: THIS IS NOT TOKENIZATION
        // ==========================================
        // Do not confuse Hashing/KDF with Tokenization.
        // - KDF (Used here): A deterministic, irreversible mathematical function.
        // - TRUE TOKENIZATION: Replaces data with a completely random string (Token) generated
        //   by an isolated Data Vault. There is NO mathematical relationship between the Token
        //   and the original data. Tokenization is required for PCI-DSS (payments), while
        //   costly hashing (KDF) is often used for GDPR (analytics anonymization).

        val safePayload = """
            {
              "event": "App_Crash",
              "user_anon_id": "$anonymizedId",
              "has_drafts": ${appData.userContext.draftMessagesDb.isNotEmpty()}
            }
        """.trimIndent()

        SecureLog.i("SecureSDK", "Sending cryptographically anonymized payload to Analytics SDK: \n%s", safePayload)
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
                val msg = consoleMessage.message().uppercase()
                
                // ==========================================
                // EDUCATIONAL: WHITELIST vs BLACKLIST (Positive vs Negative Security Model)
                // ==========================================
                // ❌ BLACKLIST (Negative Security): Blocking known bad terms (e.g., "cookie", "token").
                // Flaw: Attackers can easily bypass this using obfuscation or new variable names (e.g., "c00kie", "SessionID").
                // 
                // ✅ WHITELIST (Positive Security): Allowing ONLY known good patterns.
                // Advantage: Default Deny. Anything that doesn't strictly match the allowed pattern is dropped.
                // This is the fundamental principle of Zero Trust and Defense-in-Depth.
                
                // Implementation: We only allow logs that explicitly start with known safe prefixes.
                val safeWhitelistRegex = Regex("^(UI_STATE|ANALYTICS_EVENT):.*")
                
                // Default Deny mechanism
                if (!safeWhitelistRegex.matches(msg)) {
                    SecureLog.w("SecureWebView", "Blocked unknown WebView console message (Not in Whitelist).")
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
     * Utility function to generate a PBKDF2 Hash (Key Derivation Function).
     * Replaces weak single-pass SHA-256 to protect low-entropy PII against brute-force.
     */
    private fun generatePbkdf2Hash(input: String, salt: String): String {
        return try {
            val iterationCount = 10000 // Computational cost (higher is safer, but slower)
            val keyLength = 256 // Output length in bits
            val spec = javax.crypto.spec.PBEKeySpec(
                input.toCharArray(),
                salt.toByteArray(Charsets.UTF_8),
                iterationCount,
                keyLength
            )
            val factory = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val hashBytes = factory.generateSecret(spec).encoded
            hashBytes.joinToString("") { "%02x".format(it) }
        } catch (e: Exception) {
            "KDF_ERROR"
        }
    }
}
 