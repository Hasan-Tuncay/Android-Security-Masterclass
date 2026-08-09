package com.hasantuncay.mobsec.crypto.maswe0007

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0007Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0007CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0007Vector.entries,
        onBack = onBack
    )
}
