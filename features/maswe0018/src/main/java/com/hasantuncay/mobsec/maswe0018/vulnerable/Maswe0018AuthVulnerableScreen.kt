package com.hasantuncay.mobsec.maswe0018.vulnerable

import com.hasantuncay.mobsec.maswe0018.common.Maswe0018Vector
import com.hasantuncay.mobsec.maswe0018.common.Maswe0018Mitigation
import com.hasantuncay.mobsec.maswe0018.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0018AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0018Vector.meta,
        vectors = Maswe0018Vector.entries,
        onBack = onBack
    )
}
