package com.hasantuncay.mobsec.maswe0034.vulnerable

import com.hasantuncay.mobsec.maswe0034.common.Maswe0034Vector
import com.hasantuncay.mobsec.maswe0034.common.Maswe0034Mitigation
import com.hasantuncay.mobsec.maswe0034.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0034PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0034Vector.meta,
        vectors = Maswe0034Vector.entries,
        onBack = onBack
    )
}
