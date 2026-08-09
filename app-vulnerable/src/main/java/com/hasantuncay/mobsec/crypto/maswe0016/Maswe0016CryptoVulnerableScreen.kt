package com.hasantuncay.mobsec.crypto.maswe0016

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0016Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0016CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0016Vector.meta,
        vectors = Maswe0016Vector.entries,
        onBack = onBack
    )
}
