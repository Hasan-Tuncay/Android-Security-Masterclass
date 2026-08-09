package com.hasantuncay.mobsec.maswe0066.vulnerable

import com.hasantuncay.mobsec.maswe0066.common.Maswe0066Vector
import com.hasantuncay.mobsec.maswe0066.common.Maswe0066Mitigation
import com.hasantuncay.mobsec.maswe0066.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0066PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0066Vector.meta,
        vectors = Maswe0066Vector.entries,
        onBack = onBack
    )
}
