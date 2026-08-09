package com.hasantuncay.mobsec.secure.crypto.maswe0014

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0014Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0014CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0014Mitigation.entries,
        onBack = onBack
    )
}
