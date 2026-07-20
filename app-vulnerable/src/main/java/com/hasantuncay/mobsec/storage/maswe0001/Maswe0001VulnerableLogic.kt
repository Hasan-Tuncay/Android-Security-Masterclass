package com.hasantuncay.mobsec.storage.maswe0001

import android.content.Context
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.MasterclassData
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileOutputStream
import kotlin.concurrent.thread

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
            val file = File(context.filesDir, "diagnostics_vulnerable.log")
            Toast.makeText(context, String.format(msg, file.absolutePath), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun triggerSystemConsoleLeak(appData: MasterclassData) {
        val password = appData.userContext.plainTextPasswordInHeap
        val tc = appData.gdprPii.directIdentifiers.nationalIdentificationNumber
        Log.d("VULN_APP_TAG", "User login failed. Pwd: $password, TCKN: $tc")
    }

    private fun triggerNetworkLeak(appData: MasterclassData) {
        thread {
            val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val token = appData.networkSession.oAuth2BearerToken
            val request = Request.Builder()
                .url("https://httpbin.org/get")
                .header("Authorization", "Bearer $token")
                .build()
            try {
                client.newCall(request).execute()
            } catch (e: Exception) {
                Log.e("VULN_APP_TAG", "Network error", e)
            }
        }
    }

    private fun triggerLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            val file = File(context.filesDir, "diagnostics_vulnerable.log")
            FileOutputStream(file, true).use { stream ->
                val cc = appData.pciDss.cardholderData.primaryAccountNumber
                val logData = "Crash diagnostic... Card: $cc\n"
                stream.write(logData.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun triggerSdkTelemetryLeak(appData: MasterclassData) {
        // VULNERABILITY: Dumping a whole domain object with sensitive data to Analytics/Crash SDK
        val analyticsPayload = appData.analyticsLogs.mixpanelEventPayload
        Log.e("VULN_SDK_SIMULATION", "Sending payload to Mixpanel: $analyticsPayload")
    }

    private fun triggerWebViewConsoleLeak(appData: MasterclassData, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.d("VULN_WEBVIEW", "JS Console: " + consoleMessage.message())
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
