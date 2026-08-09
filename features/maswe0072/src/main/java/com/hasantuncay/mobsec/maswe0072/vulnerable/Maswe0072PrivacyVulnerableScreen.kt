package com.hasantuncay.mobsec.maswe0072.vulnerable

import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Vector
import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Mitigation
import com.hasantuncay.mobsec.maswe0072.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0072PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0072Vector.meta,
        vectors = Maswe0072Vector.entries,
        onBack = onBack
    )
}
