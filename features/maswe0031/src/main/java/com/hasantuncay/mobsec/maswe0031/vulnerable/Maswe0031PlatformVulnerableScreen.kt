package com.hasantuncay.mobsec.maswe0031.vulnerable

import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Vector
import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Mitigation
import com.hasantuncay.mobsec.maswe0031.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0031PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0031Vector.meta,
        vectors = Maswe0031Vector.entries,
        onBack = onBack
    )
}
