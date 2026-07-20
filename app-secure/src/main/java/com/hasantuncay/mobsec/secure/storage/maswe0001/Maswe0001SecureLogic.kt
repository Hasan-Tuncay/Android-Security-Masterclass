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
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
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
        // SECURE: Never log plain text passwords. 
        // Mask PII before logging.
        val tckn = appData.gdprPii.directIdentifiers.nationalIdentificationNumber
        val maskedTckn = if (tckn.length > 4) "****${tckn.takeLast(4)}" else "****"
        Timber.d("User login failed. TCKN: %s", maskedTckn)
    }

    private fun secureNetworkLeak(appData: MasterclassData) {
        thread {
            // SECURE: Disable body logging in production
            val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            val interceptor = HttpLoggingInterceptor().apply { this.level = level }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val token = appData.networkSession.oAuth2BearerToken
            val request = Request.Builder()
                .url("https://httpbin.org/get")
                .header("Authorization", "Bearer ${"$"}token")
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                Timber.e(e, "Network error")
            }
        }
    }

    private fun secureLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            // SECURE: Use Jetpack Security to encrypt diagnostic files if they must contain sensitive info.
            val mainKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            val file = File(context.filesDir, "diagnostics_secure.log")
            if (file.exists()) file.delete() 

            val encryptedFile = EncryptedFile.Builder(
                context,
                file,
                mainKey,
                EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
            ).build()

            encryptedFile.openFileOutput().use { stream ->
                // SECURE: Store only encrypted PAN if absolutely necessary.
                val cc = appData.pciDss.cardholderData.primaryAccountNumber
                val logData = "Crash report. Card: $cc\n"
                stream.write(logData.toByteArray())
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun secureSdkTelemetryLeak(appData: MasterclassData) {
        // SECURE: Only send non-PII, pseudo-anonymized data to analytics SDKs
        val anonymizedId = appData.analyticsLogs.mixpanelEventPayload.split(",").firstOrNull() ?: "ANON_ID"
        Timber.d("Sending to 3rd Party Server: %s", anonymizedId)
    }

    private fun secureWebViewConsoleLeak(appData: MasterclassData, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                val msg = consoleMessage.message().lowercase()
                // SECURE: Intercept and block sensitive tokens from the JS console
                if (msg.contains("password") || msg.contains("credit card") || msg.contains("token") || msg.contains("cookie")) {
                    Timber.w("Blocked sensitive WebView console message.")
                    return true 
                }
                Timber.d("JS Console: %s", consoleMessage.message())
                return true
            }
        }
        val cookie = appData.networkSession.webViewSessionCookie
        val html = """
            <html><body>
            <script>
                console.log("Saving user session: $cookie");
            </script>
            </body></html>
        """.trimIndent()
        webView.loadData(html, "text/html", "UTF-8")
    }
}
