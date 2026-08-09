package com.hasantuncay.mobsec.maswe0042.vulnerable

import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Vector
import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Mitigation
import com.hasantuncay.mobsec.maswe0042.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0042CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0042Vector.meta,
        vectors = Maswe0042Vector.entries,
        onBack = onBack
    )
}
