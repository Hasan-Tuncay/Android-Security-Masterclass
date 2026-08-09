package com.hasantuncay.mobsec.secure.crypto.maswe0011

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0011Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0011CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0011Mitigation.meta,
        vectors = Maswe0011Mitigation.entries,
        onBack = onBack
    )
}
