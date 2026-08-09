package com.hasantuncay.mobsec.maswe0052.vulnerable

import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Vector
import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Mitigation
import com.hasantuncay.mobsec.maswe0052.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0052ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0052Vector.meta,
        vectors = Maswe0052Vector.entries,
        onBack = onBack
    )
}
