package com.hasantuncay.mobsec.resilience.maswe0063

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0063Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0063ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0063Vector.entries,
        onBack = onBack
    )
}
