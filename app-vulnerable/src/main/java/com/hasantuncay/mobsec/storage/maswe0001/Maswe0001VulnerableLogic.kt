package com.hasantuncay.mobsec.storage.maswe0001

import android.content.Context
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileOutputStream
import kotlin.concurrent.thread

object Maswe0001VulnerableLogic {

    fun executeVector(vector: Maswe0001Vector, username: String, creditCard: String, context: Context) {
        when (vector) {
            Maswe0001Vector.SYSTEM_CONSOLE -> triggerSystemConsoleLeak(username, creditCard)
            Maswe0001Vector.NETWORK_INTERCEPTOR -> triggerNetworkLeak(creditCard)
            Maswe0001Vector.LOCAL_FILE -> triggerLocalFileLeak(username, creditCard, context)
            Maswe0001Vector.SDK_TELEMETRY -> triggerSdkTelemetryLeak(username, creditCard)
            Maswe0001Vector.WEBVIEW_CONSOLE -> triggerWebViewConsoleLeak(creditCard, context)
        }
        
        val msg = context.getString(vector.msgVulnRes)
        if (vector == Maswe0001Vector.LOCAL_FILE) {
            val file = File(context.filesDir, "diagnostics_vulnerable.log")
            Toast.makeText(context, String.format(msg, file.absolutePath), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun triggerSystemConsoleLeak(username: String, creditCard: String) {
        Log.d("VULN_APP_TAG", "User logging in -> Username: $username, CC: $creditCard")
    }

    private fun triggerNetworkLeak(creditCard: String) {
        thread {
            val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val request = Request.Builder()
                .url("https://httpbin.org/get")
                .header("Authorization", "Bearer MOCK_JWT_FOR_$creditCard")
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                Log.e("VULN_APP_TAG", "Network error", e)
            }
        }
    }

    private fun triggerLocalFileLeak(username: String, creditCard: String, context: Context) {
        try {
            val file = File(context.filesDir, "diagnostics_vulnerable.log")
            FileOutputStream(file, true).use { stream ->
                val logData = "Crash report for User: $username, CC: $creditCard\n"
                stream.write(logData.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun triggerSdkTelemetryLeak(username: String, creditCard: String) {
        val userObj = DomainUser(username, creditCard)
        Log.e("VULN_SDK_SIMULATION", "Sending to 3rd Party Server: $userObj")
    }

    private fun triggerWebViewConsoleLeak(creditCard: String, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.d("VULN_WEBVIEW", "JS Console: " + consoleMessage.message())
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
