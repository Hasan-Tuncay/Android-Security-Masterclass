package com.hasantuncay.mobsec.crypto.maswe0010

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0010Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0010CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0010Vector.entries,
        onBack = onBack
    )
}
