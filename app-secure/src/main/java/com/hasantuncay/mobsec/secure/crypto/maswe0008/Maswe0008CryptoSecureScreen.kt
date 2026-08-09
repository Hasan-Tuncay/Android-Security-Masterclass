package com.hasantuncay.mobsec.secure.crypto.maswe0008

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0008Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0008CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0008Mitigation.meta,
        vectors = Maswe0008Mitigation.entries,
        onBack = onBack
    )
}
