package com.hasantuncay.mobsec.maswe0070.vulnerable

import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Vector
import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Mitigation
import com.hasantuncay.mobsec.maswe0070.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0070PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0070Vector.meta,
        vectors = Maswe0070Vector.entries,
        onBack = onBack
    )
}
