package com.hasantuncay.mobsec.maswe0051.vulnerable

import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Vector
import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Mitigation
import com.hasantuncay.mobsec.maswe0051.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0051ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0051Vector.meta,
        vectors = Maswe0051Vector.entries,
        onBack = onBack
    )
}
