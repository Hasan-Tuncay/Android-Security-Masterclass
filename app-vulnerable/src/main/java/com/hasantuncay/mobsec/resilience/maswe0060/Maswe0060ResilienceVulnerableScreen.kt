package com.hasantuncay.mobsec.resilience.maswe0060

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0060Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0060ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0060Vector.entries,
        onBack = onBack
    )
}
