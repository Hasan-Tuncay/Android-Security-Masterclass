package com.hasantuncay.mobsec.secure.storage.maswe0001

import android.content.Context
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKey
import com.hasantuncay.mobsec.BuildConfig
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import kotlin.concurrent.thread

data class SafeUserDto(val username: String)

object Maswe0001SecureLogic {
    fun executeVector(vector: Maswe0001Vector, username: String, creditCard: String, context: Context) {
        when (vector) {
            Maswe0001Vector.SECURE_SYSTEM_CONSOLE -> {
                val maskedCC = if (creditCard.length > 4) "****-****-****-${creditCard.takeLast(4)}" else "****"
                Timber.d("User logging in -> Username: %s, CC: %s", username, maskedCC)
                Toast.makeText(context, "Safely logged via Timber with masking!", Toast.LENGTH_SHORT).show()
            }
            Maswe0001Vector.SECURE_NETWORK_REQUESTS -> {
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
                Toast.makeText(context, "Network executed safely. Body logs are disabled!", Toast.LENGTH_SHORT).show()
            }
            Maswe0001Vector.SECURE_LOCAL_FILE -> {
                try {
                    val mainKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
                    val file = File(context.filesDir, "diagnostics_secure.log")
                    if (file.exists()) file.delete()
                    val encryptedFile = EncryptedFile.Builder(context, file, mainKey, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build()
                    encryptedFile.openFileOutput().use { stream ->
                        val logData = "Crash report for User: $username, CC: $creditCard\n"
                        stream.write(logData.toByteArray())
                    }
                    Toast.makeText(context, "Saved securely via Jetpack Security AES-256-GCM!", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Timber.e(e)
                }
            }
            Maswe0001Vector.SECURE_SDK_TELEMETRY -> {
                val safeObj = SafeUserDto(username)
                Timber.d("Sending to 3rd Party Server: %s", safeObj)
                Toast.makeText(context, "Sanitized Object sent to Analytics SDK!", Toast.LENGTH_SHORT).show()
            }
            Maswe0001Vector.SECURE_WEBVIEW_CONSOLE -> {
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
                val html = "<html><body><script>console.log(\"Processing payment for credit card: $creditCard\");</script></body></html>"
                webView.loadData(html, "text/html", "UTF-8")
                Toast.makeText(context, "WebView JS console.log safely intercepted!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

import com.hasantuncay.mobsec.common.models.data.LocalMasterclassData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001LogSecureScreen(onBack: () -> Unit) {
    val appData = LocalMasterclassData.current
    val username = appData.gdprPii.directIdentifiers.fullName
    val creditCard = appData.pciDss.cardholderData.primaryAccountNumber
    
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.maswe_0001_secure_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                stringResource(id = R.string.maswe_0001_secure_desc),
                style = MaterialTheme.typography.bodyMedium
            )

            OutlinedTextField(
                value = username,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.maswe_0001_username)) },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = creditCard,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.maswe_0001_credit_card)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text(stringResource(id = R.string.maswe_0001_secure_vectors_title), fontWeight = FontWeight.Bold)

            Maswe0001Vector.entries.forEach { vector ->
                VectorButton(
                    title = stringResource(id = vector.titleSecureRes),
                    icon = vector.icon,
                    onClick = {
                        Maswe0001SecureLogic.executeVector(vector, username, creditCard, context)
                    }
                )
            }
        }
    }
}

@Composable
fun VectorButton(title: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title)
        }
    }
}
