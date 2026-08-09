package com.hasantuncay.mobsec.maswe0074.vulnerable

import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Vector
import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Mitigation
import com.hasantuncay.mobsec.maswe0074.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0074PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0074Vector.meta,
        vectors = Maswe0074Vector.entries,
        onBack = onBack
    )
}
