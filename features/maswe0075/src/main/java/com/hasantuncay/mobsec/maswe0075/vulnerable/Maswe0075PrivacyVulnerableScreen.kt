package com.hasantuncay.mobsec.maswe0075.vulnerable

import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Vector
import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Mitigation
import com.hasantuncay.mobsec.maswe0075.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0075PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0075Vector.meta,
        vectors = Maswe0075Vector.entries,
        onBack = onBack
    )
}
