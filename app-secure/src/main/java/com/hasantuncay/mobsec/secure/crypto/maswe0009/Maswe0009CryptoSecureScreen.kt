package com.hasantuncay.mobsec.secure.crypto.maswe0009

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0009Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0009CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0009Mitigation.entries,
        onBack = onBack
    )
}
