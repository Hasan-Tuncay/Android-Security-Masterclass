package com.hasantuncay.mobsec.resilience.maswe0065

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0065Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0065ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0065Vector.meta,
        vectors = Maswe0065Vector.entries,
        onBack = onBack
    )
}
