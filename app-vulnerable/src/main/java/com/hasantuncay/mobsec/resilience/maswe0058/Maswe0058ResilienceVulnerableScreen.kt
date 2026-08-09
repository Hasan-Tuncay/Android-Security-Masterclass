package com.hasantuncay.mobsec.resilience.maswe0058

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0058Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0058ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0058Vector.meta,
        vectors = Maswe0058Vector.entries,
        onBack = onBack
    )
}
