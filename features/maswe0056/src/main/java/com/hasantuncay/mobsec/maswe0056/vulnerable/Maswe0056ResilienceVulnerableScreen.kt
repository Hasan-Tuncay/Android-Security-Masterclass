package com.hasantuncay.mobsec.maswe0056.vulnerable

import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Vector
import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Mitigation
import com.hasantuncay.mobsec.maswe0056.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0056ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0056Vector.meta,
        vectors = Maswe0056Vector.entries,
        onBack = onBack
    )
}
