package com.hasantuncay.mobsec.secure.crypto.maswe0015

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0015Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0015CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0015Mitigation.entries,
        onBack = onBack
    )
}
