package com.hasantuncay.mobsec.resilience.maswe0061

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0061Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0061ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0061Vector.entries,
        onBack = onBack
    )
}
