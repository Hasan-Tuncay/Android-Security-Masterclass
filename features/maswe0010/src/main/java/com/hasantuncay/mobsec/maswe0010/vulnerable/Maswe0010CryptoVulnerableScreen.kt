package com.hasantuncay.mobsec.maswe0010.vulnerable

import com.hasantuncay.mobsec.maswe0010.common.Maswe0010Vector
import com.hasantuncay.mobsec.maswe0010.common.Maswe0010Mitigation
import com.hasantuncay.mobsec.maswe0010.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0010CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0010Vector.meta,
        vectors = Maswe0010Vector.entries,
        onBack = onBack
    )
}
