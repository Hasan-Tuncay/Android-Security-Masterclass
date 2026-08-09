package com.hasantuncay.mobsec.maswe0017.vulnerable

import com.hasantuncay.mobsec.maswe0017.common.Maswe0017Vector
import com.hasantuncay.mobsec.maswe0017.common.Maswe0017Mitigation
import com.hasantuncay.mobsec.maswe0017.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0017CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0017Vector.meta,
        vectors = Maswe0017Vector.entries,
        onBack = onBack
    )
}
