package com.hasantuncay.mobsec.resilience.maswe0051

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0051Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0051ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0051Vector.entries,
        onBack = onBack
    )
}
