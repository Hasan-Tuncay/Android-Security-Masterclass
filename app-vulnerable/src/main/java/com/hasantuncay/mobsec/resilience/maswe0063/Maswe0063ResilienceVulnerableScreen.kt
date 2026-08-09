package com.hasantuncay.mobsec.resilience.maswe0063

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0063Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0063ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0063Vector.meta,
        vectors = Maswe0063Vector.entries,
        onBack = onBack
    )
}
