package com.hasantuncay.mobsec.maswe0058.vulnerable

import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Vector
import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Mitigation
import com.hasantuncay.mobsec.maswe0058.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0058ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0058Vector.meta,
        vectors = Maswe0058Vector.entries,
        onBack = onBack
    )
}
