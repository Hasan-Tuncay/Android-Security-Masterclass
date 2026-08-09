package com.hasantuncay.mobsec.maswe0060.vulnerable

import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Vector
import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Mitigation
import com.hasantuncay.mobsec.maswe0060.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0060ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0060Vector.meta,
        vectors = Maswe0060Vector.entries,
        onBack = onBack
    )
}
