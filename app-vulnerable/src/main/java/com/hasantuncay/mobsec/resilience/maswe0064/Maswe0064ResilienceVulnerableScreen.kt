package com.hasantuncay.mobsec.resilience.maswe0064

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0064Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0064ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0064Vector.meta,
        vectors = Maswe0064Vector.entries,
        onBack = onBack
    )
}
