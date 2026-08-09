package com.hasantuncay.mobsec.crypto.maswe0017

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0017Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0017CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0017Vector.meta,
        vectors = Maswe0017Vector.entries,
        onBack = onBack
    )
}
