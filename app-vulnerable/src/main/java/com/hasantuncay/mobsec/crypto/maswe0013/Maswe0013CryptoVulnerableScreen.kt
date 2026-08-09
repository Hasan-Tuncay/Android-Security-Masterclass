package com.hasantuncay.mobsec.crypto.maswe0013

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0013Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0013CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0013Vector.meta,
        vectors = Maswe0013Vector.entries,
        onBack = onBack
    )
}
