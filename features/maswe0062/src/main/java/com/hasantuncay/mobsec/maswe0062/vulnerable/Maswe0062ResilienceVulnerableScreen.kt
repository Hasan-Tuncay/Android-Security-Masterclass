package com.hasantuncay.mobsec.maswe0062.vulnerable

import com.hasantuncay.mobsec.maswe0062.common.Maswe0062Vector
import com.hasantuncay.mobsec.maswe0062.common.Maswe0062Mitigation
import com.hasantuncay.mobsec.maswe0062.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0062ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0062Vector.meta,
        vectors = Maswe0062Vector.entries,
        onBack = onBack
    )
}
