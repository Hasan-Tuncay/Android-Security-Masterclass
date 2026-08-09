package com.hasantuncay.mobsec.resilience.maswe0062

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0062Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0062ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0062Vector.meta,
        vectors = Maswe0062Vector.entries,
        onBack = onBack
    )
}
