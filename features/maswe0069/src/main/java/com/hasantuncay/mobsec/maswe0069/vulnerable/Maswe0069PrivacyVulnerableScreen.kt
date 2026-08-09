package com.hasantuncay.mobsec.maswe0069.vulnerable

import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Vector
import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Mitigation
import com.hasantuncay.mobsec.maswe0069.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0069PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0069Vector.meta,
        vectors = Maswe0069Vector.entries,
        onBack = onBack
    )
}
