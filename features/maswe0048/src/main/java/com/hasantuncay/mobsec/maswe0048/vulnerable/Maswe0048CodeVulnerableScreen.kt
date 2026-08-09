package com.hasantuncay.mobsec.maswe0048.vulnerable

import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Vector
import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Mitigation
import com.hasantuncay.mobsec.maswe0048.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0048CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0048Vector.meta,
        vectors = Maswe0048Vector.entries,
        onBack = onBack
    )
}
