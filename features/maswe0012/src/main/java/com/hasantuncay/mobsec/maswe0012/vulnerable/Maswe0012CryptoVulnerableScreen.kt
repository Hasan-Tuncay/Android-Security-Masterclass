package com.hasantuncay.mobsec.maswe0012.vulnerable

import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Vector
import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Mitigation
import com.hasantuncay.mobsec.maswe0012.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0012CryptoVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0012Vector.meta,
        vectors = Maswe0012Vector.entries,
        onBack = onBack
    )
}
