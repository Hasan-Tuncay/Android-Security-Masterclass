package com.hasantuncay.mobsec.crypto.maswe0009

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0009Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0009CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0009Vector.entries,
        onBack = onBack
    )
}
