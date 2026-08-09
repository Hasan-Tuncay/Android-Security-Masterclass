package com.hasantuncay.mobsec.maswe0035.vulnerable

import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Vector
import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Mitigation
import com.hasantuncay.mobsec.maswe0035.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0035PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0035Vector.meta,
        vectors = Maswe0035Vector.entries,
        onBack = onBack
    )
}
