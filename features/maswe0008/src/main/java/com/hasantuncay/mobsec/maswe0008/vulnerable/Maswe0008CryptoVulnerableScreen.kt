package com.hasantuncay.mobsec.maswe0008.vulnerable

import com.hasantuncay.mobsec.maswe0008.common.Maswe0008Vector
import com.hasantuncay.mobsec.maswe0008.common.Maswe0008Mitigation
import com.hasantuncay.mobsec.maswe0008.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0008CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0008Vector.meta,
        vectors = Maswe0008Vector.entries,
        onBack = onBack
    )
}
