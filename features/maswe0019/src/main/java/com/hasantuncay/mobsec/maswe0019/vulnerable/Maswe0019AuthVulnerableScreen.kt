package com.hasantuncay.mobsec.maswe0019.vulnerable

import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Vector
import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Mitigation
import com.hasantuncay.mobsec.maswe0019.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0019AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0019Vector.meta,
        vectors = Maswe0019Vector.entries,
        onBack = onBack
    )
}
