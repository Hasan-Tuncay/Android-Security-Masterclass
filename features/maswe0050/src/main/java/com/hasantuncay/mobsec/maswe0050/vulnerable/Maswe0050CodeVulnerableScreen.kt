package com.hasantuncay.mobsec.maswe0050.vulnerable

import com.hasantuncay.mobsec.maswe0050.common.Maswe0050Vector
import com.hasantuncay.mobsec.maswe0050.common.Maswe0050Mitigation
import com.hasantuncay.mobsec.maswe0050.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0050CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0050Vector.meta,
        vectors = Maswe0050Vector.entries,
        onBack = onBack
    )
}
