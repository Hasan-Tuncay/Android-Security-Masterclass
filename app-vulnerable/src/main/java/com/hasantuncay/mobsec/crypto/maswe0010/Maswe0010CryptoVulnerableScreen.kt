package com.hasantuncay.mobsec.crypto.maswe0010

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.crypto.Maswe0010Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0010CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0010Vector.meta,
        vectors = Maswe0010Vector.entries,
        onBack = onBack
    )
}
