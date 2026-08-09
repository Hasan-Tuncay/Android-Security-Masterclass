package com.hasantuncay.mobsec.secure.crypto.maswe0007

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0007Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0007CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0007Mitigation.entries,
        onBack = onBack
    )
}
