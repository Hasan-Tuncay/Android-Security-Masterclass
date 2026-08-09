package com.hasantuncay.mobsec.maswe0037.vulnerable

import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Vector
import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Mitigation
import com.hasantuncay.mobsec.maswe0037.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0037PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0037Vector.meta,
        vectors = Maswe0037Vector.entries,
        onBack = onBack
    )
}
