package com.hasantuncay.mobsec.maswe0073.vulnerable

import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Vector
import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Mitigation
import com.hasantuncay.mobsec.maswe0073.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0073PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0073Vector.meta,
        vectors = Maswe0073Vector.entries,
        onBack = onBack
    )
}
