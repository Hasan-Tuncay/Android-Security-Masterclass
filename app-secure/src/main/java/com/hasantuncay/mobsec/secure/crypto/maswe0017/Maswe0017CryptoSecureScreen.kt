package com.hasantuncay.mobsec.secure.crypto.maswe0017

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0017Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0017CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0017Mitigation.entries,
        onBack = onBack
    )
}
