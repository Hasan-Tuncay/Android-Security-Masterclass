package com.hasantuncay.mobsec.maswe0046.vulnerable

import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Vector
import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Mitigation
import com.hasantuncay.mobsec.maswe0046.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0046CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0046Vector.meta,
        vectors = Maswe0046Vector.entries,
        onBack = onBack
    )
}
