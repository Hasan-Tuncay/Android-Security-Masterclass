package com.hasantuncay.mobsec.maswe0063.vulnerable

import com.hasantuncay.mobsec.maswe0063.common.Maswe0063Vector
import com.hasantuncay.mobsec.maswe0063.common.Maswe0063Mitigation
import com.hasantuncay.mobsec.maswe0063.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0063ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0063Vector.meta,
        vectors = Maswe0063Vector.entries,
        onBack = onBack
    )
}
