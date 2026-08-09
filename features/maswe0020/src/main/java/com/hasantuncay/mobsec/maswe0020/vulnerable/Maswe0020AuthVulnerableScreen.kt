package com.hasantuncay.mobsec.maswe0020.vulnerable

import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Vector
import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Mitigation
import com.hasantuncay.mobsec.maswe0020.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0020AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0020Vector.meta,
        vectors = Maswe0020Vector.entries,
        onBack = onBack
    )
}
