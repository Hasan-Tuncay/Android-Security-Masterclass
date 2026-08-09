package com.hasantuncay.mobsec.maswe0009.vulnerable

import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Vector
import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Mitigation
import com.hasantuncay.mobsec.maswe0009.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0009CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0009Vector.meta,
        vectors = Maswe0009Vector.entries,
        onBack = onBack
    )
}
