package com.hasantuncay.mobsec.secure.crypto.maswe0010

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0010Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0010CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0010Mitigation.meta,
        vectors = Maswe0010Mitigation.entries,
        onBack = onBack
    )
}
