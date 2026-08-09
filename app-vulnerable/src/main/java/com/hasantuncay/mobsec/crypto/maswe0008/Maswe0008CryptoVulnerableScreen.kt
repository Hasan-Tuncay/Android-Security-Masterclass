package com.hasantuncay.mobsec.crypto.maswe0008

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0008Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0008CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0008Vector.entries,
        onBack = onBack
    )
}
