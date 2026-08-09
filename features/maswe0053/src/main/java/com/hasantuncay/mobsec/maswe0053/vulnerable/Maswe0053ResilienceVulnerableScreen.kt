package com.hasantuncay.mobsec.maswe0053.vulnerable

import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Vector
import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Mitigation
import com.hasantuncay.mobsec.maswe0053.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0053ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0053Vector.meta,
        vectors = Maswe0053Vector.entries,
        onBack = onBack
    )
}
