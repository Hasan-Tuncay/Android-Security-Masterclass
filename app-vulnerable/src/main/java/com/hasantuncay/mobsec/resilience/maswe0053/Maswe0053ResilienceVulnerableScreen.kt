package com.hasantuncay.mobsec.resilience.maswe0053

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0053Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0053ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0053Vector.entries,
        onBack = onBack
    )
}
