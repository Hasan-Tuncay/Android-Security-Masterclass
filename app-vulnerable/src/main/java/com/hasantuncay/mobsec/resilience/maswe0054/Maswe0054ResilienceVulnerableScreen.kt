package com.hasantuncay.mobsec.resilience.maswe0054

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0054Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0054ResilienceVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0054Vector.meta,
        vectors = Maswe0054Vector.entries,
        onBack = onBack
    )
}
