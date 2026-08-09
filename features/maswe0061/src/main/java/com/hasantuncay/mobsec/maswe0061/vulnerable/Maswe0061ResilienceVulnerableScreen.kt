package com.hasantuncay.mobsec.maswe0061.vulnerable

import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Vector
import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Mitigation
import com.hasantuncay.mobsec.maswe0061.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0061ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0061Vector.meta,
        vectors = Maswe0061Vector.entries,
        onBack = onBack
    )
}
