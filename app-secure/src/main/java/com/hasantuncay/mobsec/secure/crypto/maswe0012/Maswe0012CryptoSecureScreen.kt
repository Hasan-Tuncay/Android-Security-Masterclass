package com.hasantuncay.mobsec.secure.crypto.maswe0012

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0012Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0012CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0012Mitigation.entries,
        onBack = onBack
    )
}
