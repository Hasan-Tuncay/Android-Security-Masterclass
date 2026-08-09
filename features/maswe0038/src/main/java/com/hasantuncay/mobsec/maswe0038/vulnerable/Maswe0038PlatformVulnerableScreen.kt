package com.hasantuncay.mobsec.maswe0038.vulnerable

import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Vector
import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Mitigation
import com.hasantuncay.mobsec.maswe0038.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0038PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0038Vector.meta,
        vectors = Maswe0038Vector.entries,
        onBack = onBack
    )
}
