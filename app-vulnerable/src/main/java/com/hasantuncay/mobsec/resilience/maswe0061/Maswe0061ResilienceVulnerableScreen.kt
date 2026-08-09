package com.hasantuncay.mobsec.resilience.maswe0061

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0061Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0061ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0061Vector.meta,
        vectors = Maswe0061Vector.entries,
        onBack = onBack
    )
}
