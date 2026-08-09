package com.hasantuncay.mobsec.maswe0027.vulnerable

import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Vector
import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Mitigation
import com.hasantuncay.mobsec.maswe0027.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0027NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0027Vector.meta,
        vectors = Maswe0027Vector.entries,
        onBack = onBack
    )
}
