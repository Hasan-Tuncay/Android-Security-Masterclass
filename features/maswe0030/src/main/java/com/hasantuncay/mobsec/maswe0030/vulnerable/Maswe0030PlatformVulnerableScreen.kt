package com.hasantuncay.mobsec.maswe0030.vulnerable

import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Vector
import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Mitigation
import com.hasantuncay.mobsec.maswe0030.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0030PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0030Vector.meta,
        vectors = Maswe0030Vector.entries,
        onBack = onBack
    )
}
