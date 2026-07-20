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
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import timber.log.Timber
import java.io.File
import java.security.MessageDigest
import kotlin.concurrent.thread

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

    private fun secureSystemConsoleLeak(appData: MasterclassData) {
        // SECURE: Generic, safe logging. Never dump domain objects or PII/PCI directly.
        Timber.e("Application encountered a recoverable error. ErrorCode: E-450. SessionActive: true")
    }

    private fun secureNetworkLeak(appData: MasterclassData) {
        thread {
            // SECURE: Completely disable network logging in production.
            val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.NONE
            val loggingInterceptor = HttpLoggingInterceptor().apply { this.level = level }
            
            // SECURE: Even if debugging is enabled, implement a Redacting Interceptor for sensitive headers/body
            val redactingInterceptor = Interceptor { chain ->
                val request = chain.request()
                // In a real app, you would clone the request, redact the body/headers, and then log the redacted version.
                // For this simulation, we just ensure Authorization is never logged.
                val authHeader = request.header("Authorization")
                if (authHeader != null && BuildConfig.DEBUG) {
                    Timber.d("Outgoing request with REDACTED Authorization header.")
                }
                chain.proceed(request)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(redactingInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
                
            val token = appData.networkSession.oAuth2BearerToken
            val endpoint = appData.systemCrypto.backendGraphqlEndpoint
            val request = Request.Builder()
                .url(endpoint)
                .header("Authorization", "Bearer $token")
                .header("X-CSRF-Token", appData.networkSession.csrfToken)
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                // Generic log
                Timber.e("Network request failed securely without dumping headers.")
            }
        }
    }

    private fun secureLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            // SECURE: Filter out ultra-sensitive data (CVV, PIN) which MUST NOT be stored, 
            // even if encrypted, per PCI-DSS guidelines.
            val dumpObj = JSONObject().apply {
                put("hipaa_diagnosis", appData.hipaaPhi.icd10DiagnosisCode)
                put("device_ssaid", appData.deviceTelemetry.androidSsaid)
                // CVV and PIN are explicitly excluded.
                // PAN is heavily masked (e.g. first 6, last 4)
                val pan = appData.pciDss.cardholderData.primaryAccountNumber
                val maskedPan = if (pan.length > 10) "${pan.take(6)}******${pan.takeLast(4)}" else "MASKED"
                put("pan", maskedPan)
            }

            // SECURE: Use Jetpack Security to encrypt the diagnostic file.
            val mainKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            val file = File(context.filesDir, "diagnostics_secure.json")
            if (file.exists()) file.delete() 

            val encryptedFile = EncryptedFile.Builder(
                context,
                file,
                mainKey,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
            ).build()

            encryptedFile.openFileOutput().use { stream ->
                stream.write(dumpObj.toString(4).toByteArray())
            }
            Timber.i("Secure diagnostic file written with Jetpack Security and PCI-DSS compliance.")
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun secureSdkTelemetryLeak(appData: MasterclassData) {
        // SECURE: Data Sanitization before sending to Analytics
        val email = appData.gdprPii.directIdentifiers.personalEmail
        val emailHash = hashString(email)
        
        val safePayload = """
            {
              "event": "App_Crash",
              "user_id_hash": "$emailHash",
              "has_drafts": ${appData.userContext.draftMessagesDb.isNotEmpty()}
            }
        """.trimIndent()
        
        Timber.i("Sending sanitized, anonymous payload to Analytics SDK: \n$safePayload")
    }

    private fun secureWebViewConsoleLeak(appData: MasterclassData, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                val msg = consoleMessage.message().lowercase()
                // SECURE: Intercept and block sensitive tokens from the JS console using Regex or Keyword filtering
                val sensitiveKeywords = listOf("cookie", "token", "auth", "bearer", "password")
                if (sensitiveKeywords.any { msg.contains(it) }) {
                    Timber.w("Blocked a potentially sensitive WebView console message.")
                    return true // Handled, won't be printed
                }
                if (BuildConfig.DEBUG) {
                    Timber.d("JS Console: %s", consoleMessage.message())
                }
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
                console.log("UI_STATE: Rendered Successfully");
            </script>
            </body></html>
        """.trimIndent()
        webView.loadData(html, "text/html", "UTF-8")
    }

    private fun hashString(input: String): String {
        return try {
            val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
            bytes.joinToString("") { "%02x".format(it) }
        } catch (e: Exception) {
            "HASH_ERROR"
        }
    }
}
