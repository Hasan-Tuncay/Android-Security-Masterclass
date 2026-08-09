package com.hasantuncay.mobsec.resilience.maswe0056

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0056Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0056ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0056Vector.entries,
        onBack = onBack
    )
}
