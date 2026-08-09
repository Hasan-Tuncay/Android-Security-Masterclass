package com.hasantuncay.mobsec.secure.resilience.maswe0051

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0051Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0051ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0051Mitigation.meta,
        vectors = Maswe0051Mitigation.entries,
        onBack = onBack
    )
}
