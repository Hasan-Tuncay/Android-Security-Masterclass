package com.hasantuncay.mobsec.maswe0078.vulnerable

import com.hasantuncay.mobsec.maswe0078.common.Maswe0078Vector
import com.hasantuncay.mobsec.maswe0078.common.Maswe0078Mitigation
import com.hasantuncay.mobsec.maswe0078.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0078PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0078Vector.meta,
        vectors = Maswe0078Vector.entries,
        onBack = onBack
    )
}
