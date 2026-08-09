package com.hasantuncay.mobsec.common.ui

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView
import com.hasantuncay.mobsec.common.R

enum class MasvsCategoryType(val categoryName: String) {
    STORAGE("MASVS-STORAGE"),
    CRYPTO("MASVS-CRYPTO"),
    AUTH("MASVS-AUTH"),
    NETWORK("MASVS-NETWORK"),
    PLATFORM("MASVS-PLATFORM"),
    CODE("MASVS-CODE"),
    RESILIENCE("MASVS-RESILIENCE"),
    PRIVACY("MASVS-PRIVACY")
}

fun getCategoryForMasweId(masweId: String): MasvsCategoryType {
    val idNum = masweId.removePrefix("MASWE-").toIntOrNull() ?: return MasvsCategoryType.STORAGE
    return when (idNum) {
        in 1..6 -> MasvsCategoryType.STORAGE
        in 7..17 -> MasvsCategoryType.CRYPTO
        in 18..25 -> MasvsCategoryType.AUTH
        in 26..28 -> MasvsCategoryType.NETWORK
        in 29..40 -> MasvsCategoryType.PLATFORM
        in 41..50 -> MasvsCategoryType.CODE
        in 51..65 -> MasvsCategoryType.RESILIENCE
        in 66..78 -> MasvsCategoryType.PRIVACY
        else -> MasvsCategoryType.STORAGE
    }
}

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MasweDocScreen(masweId: String, onBack: () -> Unit) {
    val category = getCategoryForMasweId(masweId)
    val url = "https://mas.owasp.org/MASWE/${category.categoryName}/$masweId/"
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.maswe_docs_title, masweId), fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
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
        ) {
            AndroidView(
                factory = { context ->
                    WebView(context).apply {
                        webViewClient = WebViewClient()
                        webChromeClient = WebChromeClient()
                        settings.apply {
                            javaScriptEnabled = true
                            domStorageEnabled = true
                            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                        }
                        loadUrl(url)
                    }
                },
                update = { webView ->
                    webView.loadUrl(url)
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
