package com.hasantuncay.mobsec.maswe0025.vulnerable

import com.hasantuncay.mobsec.maswe0025.common.Maswe0025Vector
import com.hasantuncay.mobsec.maswe0025.common.Maswe0025Mitigation
import com.hasantuncay.mobsec.maswe0025.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0025AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0025Vector.meta,
        vectors = Maswe0025Vector.entries,
        onBack = onBack
    )
}
