package com.hasantuncay.mobsec.maswe0029.vulnerable

import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Vector
import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Mitigation
import com.hasantuncay.mobsec.maswe0029.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0029PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0029Vector.meta,
        vectors = Maswe0029Vector.entries,
        onBack = onBack
    )
}
