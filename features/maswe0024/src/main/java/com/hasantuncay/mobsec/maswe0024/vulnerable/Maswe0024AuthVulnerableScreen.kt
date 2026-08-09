package com.hasantuncay.mobsec.maswe0024.vulnerable

import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Vector
import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Mitigation
import com.hasantuncay.mobsec.maswe0024.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0024AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0024Vector.meta,
        vectors = Maswe0024Vector.entries,
        onBack = onBack
    )
}
