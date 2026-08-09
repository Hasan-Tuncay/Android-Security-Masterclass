package com.hasantuncay.mobsec.maswe0023.vulnerable

import com.hasantuncay.mobsec.maswe0023.common.Maswe0023Vector
import com.hasantuncay.mobsec.maswe0023.common.Maswe0023Mitigation
import com.hasantuncay.mobsec.maswe0023.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0023AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0023Vector.meta,
        vectors = Maswe0023Vector.entries,
        onBack = onBack
    )
}
