package com.hasantuncay.mobsec.secure.crypto.maswe0013

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0013Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0013CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0013Mitigation.meta,
        vectors = Maswe0013Mitigation.entries,
        onBack = onBack
    )
}
