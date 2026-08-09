package com.hasantuncay.mobsec.maswe0068.vulnerable

import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Vector
import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Mitigation
import com.hasantuncay.mobsec.maswe0068.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0068PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0068Vector.meta,
        vectors = Maswe0068Vector.entries,
        onBack = onBack
    )
}
