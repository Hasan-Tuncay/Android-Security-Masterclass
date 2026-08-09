package com.hasantuncay.mobsec.resilience.maswe0059

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0059Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0059ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0059Vector.meta,
        vectors = Maswe0059Vector.entries,
        onBack = onBack
    )
}
