package com.hasantuncay.mobsec.maswe0014.vulnerable

import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Vector
import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Mitigation
import com.hasantuncay.mobsec.maswe0014.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0014CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0014Vector.meta,
        vectors = Maswe0014Vector.entries,
        onBack = onBack
    )
}
