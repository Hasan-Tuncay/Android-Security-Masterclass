package com.hasantuncay.mobsec.maswe0065.vulnerable

import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Vector
import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Mitigation
import com.hasantuncay.mobsec.maswe0065.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0065ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0065Vector.meta,
        vectors = Maswe0065Vector.entries,
        onBack = onBack
    )
}
