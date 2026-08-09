package com.hasantuncay.mobsec.secure.crypto.maswe0009

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0009Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0009CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0009Mitigation.meta,
        vectors = Maswe0009Mitigation.entries,
        onBack = onBack
    )
}
