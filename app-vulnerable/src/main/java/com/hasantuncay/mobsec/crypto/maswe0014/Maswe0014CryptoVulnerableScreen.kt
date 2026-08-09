package com.hasantuncay.mobsec.crypto.maswe0014

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0014Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0014CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0014Vector.meta,
        vectors = Maswe0014Vector.entries,
        onBack = onBack
    )
}
