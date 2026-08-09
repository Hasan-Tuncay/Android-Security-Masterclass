package com.hasantuncay.mobsec.maswe0039.vulnerable

import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Vector
import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Mitigation
import com.hasantuncay.mobsec.maswe0039.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0039PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0039Vector.meta,
        vectors = Maswe0039Vector.entries,
        onBack = onBack
    )
}
