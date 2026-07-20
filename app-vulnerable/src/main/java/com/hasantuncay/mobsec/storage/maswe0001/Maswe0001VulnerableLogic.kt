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

    private fun triggerSystemConsoleLeak(appData: MasterclassData) {
        // VULNERABLE: Dumping the entire application state in plain text to Logcat.
        val dump = """
            
            --- CRITICAL APP STATE DUMP ---
            [System Data] 
            Master Key: ${appData.systemCrypto.masterCryptoKeyAesGcm}
            RSA Private: ${appData.systemCrypto.rsaPrivateKeyPem.take(30)}...
            
            [GDPR PII Data]
            Name: ${appData.gdprPii.directIdentifiers.fullName}
            TCKN: ${appData.gdprPii.directIdentifiers.nationalIdentificationNumber}
            Email: ${appData.gdprPii.directIdentifiers.personalEmail}
            
            [User Data]
            Password (Plain): ${appData.userContext.plainTextPasswordInHeap}
            --------------------------------
        """.trimIndent()
        Log.e("VULN_APP_TAG", dump)
    }

    private fun triggerNetworkLeak(appData: MasterclassData) {
        thread {
            // VULNERABLE: Logging HTTP Headers and Body explicitly
            val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val headerDumpInterceptor = Interceptor { chain ->
                val request = chain.request()
                // Explicitly logging the headers which contains OAuth token
                Log.e("VULN_NETWORK", "Outgoing Request Headers: \n${request.headers}")
                chain.proceed(request)
            }
            
            val client = OkHttpClient.Builder()
                .addInterceptor(headerDumpInterceptor)
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
                Log.e("VULN_APP_TAG", "Network error (simulated) on $endpoint")
            }
        }
    }

    private fun triggerLocalFileLeak(appData: MasterclassData, context: Context) {
        try {
            val file = File(context.filesDir, "diagnostics_vulnerable.json")
            FileOutputStream(file, false).use { stream ->
                // VULNERABLE: Writing highly sensitive PCI/HIPAA data to a plaintext file
                val dumpObj = JSONObject().apply {
                    put("pan", appData.pciDss.cardholderData.primaryAccountNumber)
                    put("cvv", appData.pciDss.sensitiveAuthenticationData.cardVerificationCode)
                    put("pinBlock", appData.pciDss.sensitiveAuthenticationData.pinBlock)
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

    private fun triggerSdkTelemetryLeak(appData: MasterclassData) {
        // VULNERABLE: Dumping entire domain objects with sensitive data to Analytics/Crash SDK
        val payload = """
            {
              "event": "App_Crash",
              "user_email": "${appData.gdprPii.directIdentifiers.personalEmail}",
              "clipboard": "${appData.userContext.clipboardCache}",
              "draft_messages": ${appData.userContext.draftMessagesDb},
              "sim_iccid": "${appData.deviceTelemetry.simCardIccid}"
            }
        """.trimIndent()
        Log.e("VULN_SDK_SIMULATION", "Sending Crashlytics Payload: \n$payload")
    }

    private fun triggerWebViewConsoleLeak(appData: MasterclassData, context: Context) {
        val webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                // VULNERABLE: Bridging sensitive JS console logs back to native Logcat
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
