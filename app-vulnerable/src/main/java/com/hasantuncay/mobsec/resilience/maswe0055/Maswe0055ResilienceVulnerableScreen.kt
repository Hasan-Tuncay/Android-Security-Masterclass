package com.hasantuncay.mobsec.resilience.maswe0055

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0055Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0055ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0055Vector.entries,
        onBack = onBack
    )
}
