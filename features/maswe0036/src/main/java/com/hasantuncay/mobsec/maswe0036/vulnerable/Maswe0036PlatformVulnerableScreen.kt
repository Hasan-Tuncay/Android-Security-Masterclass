package com.hasantuncay.mobsec.maswe0036.vulnerable

import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Vector
import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Mitigation
import com.hasantuncay.mobsec.maswe0036.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0036PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0036Vector.meta,
        vectors = Maswe0036Vector.entries,
        onBack = onBack
    )
}
