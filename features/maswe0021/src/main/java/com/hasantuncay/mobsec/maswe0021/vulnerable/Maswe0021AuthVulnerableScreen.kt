package com.hasantuncay.mobsec.maswe0021.vulnerable

import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Vector
import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Mitigation
import com.hasantuncay.mobsec.maswe0021.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0021AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0021Vector.meta,
        vectors = Maswe0021Vector.entries,
        onBack = onBack
    )
}
