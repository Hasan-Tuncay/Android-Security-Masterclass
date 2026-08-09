package com.hasantuncay.mobsec.crypto.maswe0015

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0015Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0015CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0015Vector.meta,
        vectors = Maswe0015Vector.entries,
        onBack = onBack
    )
}
