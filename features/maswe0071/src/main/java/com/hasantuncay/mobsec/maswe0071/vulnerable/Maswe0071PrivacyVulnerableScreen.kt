package com.hasantuncay.mobsec.maswe0071.vulnerable

import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Vector
import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Mitigation
import com.hasantuncay.mobsec.maswe0071.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0071PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0071Vector.meta,
        vectors = Maswe0071Vector.entries,
        onBack = onBack
    )
}
