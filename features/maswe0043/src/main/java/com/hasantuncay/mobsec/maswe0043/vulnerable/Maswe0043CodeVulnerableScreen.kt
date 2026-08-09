package com.hasantuncay.mobsec.maswe0043.vulnerable

import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Vector
import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Mitigation
import com.hasantuncay.mobsec.maswe0043.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0043CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0043Vector.meta,
        vectors = Maswe0043Vector.entries,
        onBack = onBack
    )
}
