package com.hasantuncay.mobsec.maswe0076.vulnerable

import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Vector
import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Mitigation
import com.hasantuncay.mobsec.maswe0076.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0076PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0076Vector.meta,
        vectors = Maswe0076Vector.entries,
        onBack = onBack
    )
}
