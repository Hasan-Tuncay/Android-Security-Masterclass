package com.hasantuncay.mobsec.maswe0059.vulnerable

import com.hasantuncay.mobsec.maswe0059.common.Maswe0059Vector
import com.hasantuncay.mobsec.maswe0059.common.Maswe0059Mitigation
import com.hasantuncay.mobsec.maswe0059.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0059ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0059Vector.meta,
        vectors = Maswe0059Vector.entries,
        onBack = onBack
    )
}
