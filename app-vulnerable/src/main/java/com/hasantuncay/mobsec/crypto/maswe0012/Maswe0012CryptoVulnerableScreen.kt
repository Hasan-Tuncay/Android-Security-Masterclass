package com.hasantuncay.mobsec.crypto.maswe0012

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0012Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0012CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0012Vector.entries,
        onBack = onBack
    )
}
