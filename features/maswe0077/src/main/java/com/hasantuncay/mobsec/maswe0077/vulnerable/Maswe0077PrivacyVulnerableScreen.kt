package com.hasantuncay.mobsec.maswe0077.vulnerable

import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Vector
import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Mitigation
import com.hasantuncay.mobsec.maswe0077.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0077PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0077Vector.meta,
        vectors = Maswe0077Vector.entries,
        onBack = onBack
    )
}
