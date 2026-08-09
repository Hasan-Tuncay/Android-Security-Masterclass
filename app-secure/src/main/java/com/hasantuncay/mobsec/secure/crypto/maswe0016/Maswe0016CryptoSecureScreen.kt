package com.hasantuncay.mobsec.secure.crypto.maswe0016

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0016Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0016CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0016Mitigation.meta,
        vectors = Maswe0016Mitigation.entries,
        onBack = onBack
    )
}
