package com.hasantuncay.mobsec.maswe0057.vulnerable

import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Vector
import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Mitigation
import com.hasantuncay.mobsec.maswe0057.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0057ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0057Vector.meta,
        vectors = Maswe0057Vector.entries,
        onBack = onBack
    )
}
