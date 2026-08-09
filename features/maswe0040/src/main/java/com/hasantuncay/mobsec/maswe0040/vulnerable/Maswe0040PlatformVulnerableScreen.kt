package com.hasantuncay.mobsec.maswe0040.vulnerable

import com.hasantuncay.mobsec.maswe0040.common.Maswe0040Vector
import com.hasantuncay.mobsec.maswe0040.common.Maswe0040Mitigation
import com.hasantuncay.mobsec.maswe0040.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0040PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0040Vector.meta,
        vectors = Maswe0040Vector.entries,
        onBack = onBack
    )
}
