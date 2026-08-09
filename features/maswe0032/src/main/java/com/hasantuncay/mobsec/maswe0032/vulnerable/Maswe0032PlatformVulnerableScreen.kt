package com.hasantuncay.mobsec.maswe0032.vulnerable

import com.hasantuncay.mobsec.maswe0032.common.Maswe0032Vector
import com.hasantuncay.mobsec.maswe0032.common.Maswe0032Mitigation
import com.hasantuncay.mobsec.maswe0032.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0032PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0032Vector.meta,
        vectors = Maswe0032Vector.entries,
        onBack = onBack
    )
}
