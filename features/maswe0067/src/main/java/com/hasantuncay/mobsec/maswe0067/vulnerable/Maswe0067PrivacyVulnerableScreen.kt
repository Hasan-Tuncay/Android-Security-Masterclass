package com.hasantuncay.mobsec.maswe0067.vulnerable

import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Vector
import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Mitigation
import com.hasantuncay.mobsec.maswe0067.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0067PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0067Vector.meta,
        vectors = Maswe0067Vector.entries,
        onBack = onBack
    )
}
