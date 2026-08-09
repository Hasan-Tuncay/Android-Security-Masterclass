package com.hasantuncay.mobsec.resilience.maswe0052

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0052Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0052ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0052Vector.meta,
        vectors = Maswe0052Vector.entries,
        onBack = onBack
    )
}
