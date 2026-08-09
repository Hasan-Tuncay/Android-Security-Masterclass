package com.hasantuncay.mobsec.resilience.maswe0062

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0062Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0062ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0062Vector.entries,
        onBack = onBack
    )
}
