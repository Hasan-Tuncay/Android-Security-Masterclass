package com.hasantuncay.mobsec.resilience.maswe0057

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0057Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0057ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0057Vector.meta,
        vectors = Maswe0057Vector.entries,
        onBack = onBack
    )
}
