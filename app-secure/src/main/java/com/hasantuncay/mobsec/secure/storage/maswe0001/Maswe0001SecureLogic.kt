package com.hasantuncay.mobsec.secure.storage.maswe0001

import android.content.Context
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import com.hasantuncay.mobsec.secure.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import kotlin.concurrent.thread

object Maswe0001SecureLogic {

    fun executeVector(vector: Maswe0001Vector, username: String, creditCard: String, context: Context) {
        when (vector) {
            Maswe0001Vector.SYSTEM_CONSOLE -> secureSystemConsoleLeak(username, creditCard)
            Maswe0001Vector.NETWORK_INTERCEPTOR -> secureNetworkLeak()
            Maswe0001Vector.LOCAL_FILE -> secureLocalFileLeak(username, creditCard, context)
            Maswe0001Vector.SDK_TELEMETRY -> secureSdkTelemetryLeak(username)
            Maswe0001Vector.WEBVIEW_CONSOLE -> secureWebViewConsoleLeak(creditCard, context)
        }
        
        val msg = context.getString(vector.msgSecureRes)
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun secureSystemConsoleLeak(username: String, creditCard: String) {
        val maskedCC = if (creditCard.length > 4) "****-****-****-${creditCard.takeLast(4)}" else "****"
        Timber.d("User logging in -> Username: %s, CC: %s", username, maskedCC)
    }

    private fun secureNetworkLeak() {
        thread {
            val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            val interceptor = HttpLoggingInterceptor().apply { this.level = level }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val request = Request.Builder()
                .url("https://httpbin.org/get")
                .header("Authorization", "Bearer MOCK_JWT_FOR_SECURE_TEST")
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                Timber.e(e, "Network error")
            }
        }
    }

    private fun secureLocalFileLeak(username: String, creditCard: String, context: Context) {
        try {
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
                val logData = "Crash report for User: $username, CC: $creditCard\n"
                stream.write(logData.toByteArray())
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun secureSdkTelemetryLeak(username: String) {
        val safeObj = SafeUserDto(username)
        Timber.d("Sending to 3rd Party Server: %s", safeObj)
    }

    private fun secureWebViewConsoleLeak(creditCard: String, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                val msg = consoleMessage.message().lowercase()
                if (msg.contains("password") || msg.contains("credit card") || msg.contains("token")) {
                    Timber.w("Blocked sensitive WebView console message.")
                    return true 
                }
                Timber.d("JS Console: %s", consoleMessage.message())
                return true
            }
        }
        val html = """
            <html><body>
            <script>
                console.log("Processing payment for credit card: $creditCard");
            </script>
            </body></html>
        """.trimIndent()
        webView.loadData(html, "text/html", "UTF-8")
    }
}
