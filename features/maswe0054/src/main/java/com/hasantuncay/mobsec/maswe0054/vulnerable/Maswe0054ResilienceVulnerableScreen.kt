package com.hasantuncay.mobsec.maswe0054.vulnerable

import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Vector
import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Mitigation
import com.hasantuncay.mobsec.maswe0054.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0054ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0054Vector.meta,
        vectors = Maswe0054Vector.entries,
        onBack = onBack
    )
}
