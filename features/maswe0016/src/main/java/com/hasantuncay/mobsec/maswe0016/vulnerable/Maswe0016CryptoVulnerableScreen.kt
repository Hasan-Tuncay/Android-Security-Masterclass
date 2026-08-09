package com.hasantuncay.mobsec.maswe0016.vulnerable

import com.hasantuncay.mobsec.maswe0016.common.Maswe0016Vector
import com.hasantuncay.mobsec.maswe0016.common.Maswe0016Mitigation
import com.hasantuncay.mobsec.maswe0016.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0016CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0016Vector.meta,
        vectors = Maswe0016Vector.entries,
        onBack = onBack
    )
}
