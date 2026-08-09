package com.hasantuncay.mobsec.maswe0015.vulnerable

import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Vector
import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Mitigation
import com.hasantuncay.mobsec.maswe0015.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0015CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0015Vector.meta,
        vectors = Maswe0015Vector.entries,
        onBack = onBack
    )
}
