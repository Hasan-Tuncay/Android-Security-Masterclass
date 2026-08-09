package com.hasantuncay.mobsec.maswe0055.vulnerable

import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Vector
import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Mitigation
import com.hasantuncay.mobsec.maswe0055.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0055ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0055Vector.meta,
        vectors = Maswe0055Vector.entries,
        onBack = onBack
    )
}
