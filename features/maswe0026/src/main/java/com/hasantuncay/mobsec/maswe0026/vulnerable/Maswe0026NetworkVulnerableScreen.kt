package com.hasantuncay.mobsec.maswe0026.vulnerable

import com.hasantuncay.mobsec.maswe0026.common.Maswe0026Vector
import com.hasantuncay.mobsec.maswe0026.common.Maswe0026Mitigation
import com.hasantuncay.mobsec.maswe0026.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0026NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0026Vector.meta,
        vectors = Maswe0026Vector.entries,
        onBack = onBack
    )
}
