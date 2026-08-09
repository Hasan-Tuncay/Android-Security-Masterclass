package com.hasantuncay.mobsec.maswe0022.vulnerable

import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Vector
import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Mitigation
import com.hasantuncay.mobsec.maswe0022.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0022AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0022Vector.meta,
        vectors = Maswe0022Vector.entries,
        onBack = onBack
    )
}
