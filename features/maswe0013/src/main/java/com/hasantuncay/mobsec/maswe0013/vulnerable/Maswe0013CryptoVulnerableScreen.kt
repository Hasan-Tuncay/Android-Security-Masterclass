package com.hasantuncay.mobsec.maswe0013.vulnerable

import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Vector
import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Mitigation
import com.hasantuncay.mobsec.maswe0013.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0013CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0013Vector.meta,
        vectors = Maswe0013Vector.entries,
        onBack = onBack
    )
}
