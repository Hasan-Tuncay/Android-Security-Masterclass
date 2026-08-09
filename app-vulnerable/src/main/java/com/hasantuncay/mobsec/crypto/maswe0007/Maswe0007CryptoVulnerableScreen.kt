package com.hasantuncay.mobsec.crypto.maswe0007

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0007Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0007CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0007Vector.meta,
        vectors = Maswe0007Vector.entries,
        onBack = onBack
    )
}
