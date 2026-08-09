package com.hasantuncay.mobsec.resilience.maswe0054

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0054Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0054ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0054Vector.entries,
        onBack = onBack
    )
}
