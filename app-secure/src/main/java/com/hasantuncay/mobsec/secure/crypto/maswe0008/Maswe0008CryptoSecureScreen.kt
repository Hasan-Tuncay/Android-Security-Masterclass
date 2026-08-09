package com.hasantuncay.mobsec.secure.crypto.maswe0008

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0008Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0008CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0008Mitigation.entries,
        onBack = onBack
    )
}
