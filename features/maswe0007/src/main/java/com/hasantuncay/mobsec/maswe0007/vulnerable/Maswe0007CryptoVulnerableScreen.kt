package com.hasantuncay.mobsec.maswe0007.vulnerable

import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Mitigation
import com.hasantuncay.mobsec.maswe0007.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0007CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0007Vector.meta,
        vectors = Maswe0007Vector.entries,
        onBack = onBack
    )
}
