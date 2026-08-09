package com.hasantuncay.mobsec.maswe0041.vulnerable

import com.hasantuncay.mobsec.maswe0041.common.Maswe0041Vector
import com.hasantuncay.mobsec.maswe0041.common.Maswe0041Mitigation
import com.hasantuncay.mobsec.maswe0041.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0041CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0041Vector.meta,
        vectors = Maswe0041Vector.entries,
        onBack = onBack
    )
}
