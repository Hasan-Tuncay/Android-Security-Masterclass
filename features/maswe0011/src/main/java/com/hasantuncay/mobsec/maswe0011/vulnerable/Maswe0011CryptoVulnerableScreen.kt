package com.hasantuncay.mobsec.maswe0011.vulnerable

import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Vector
import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Mitigation
import com.hasantuncay.mobsec.maswe0011.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0011CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0011Vector.meta,
        vectors = Maswe0011Vector.entries,
        onBack = onBack
    )
}
