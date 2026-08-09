package com.hasantuncay.mobsec.crypto.maswe0011

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0011Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0011CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0011Vector.entries,
        onBack = onBack
    )
}
