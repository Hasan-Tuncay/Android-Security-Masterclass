package com.hasantuncay.mobsec.secure.resilience.maswe0052

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0052Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0052ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0052Mitigation.meta,
        vectors = Maswe0052Mitigation.entries,
        onBack = onBack
    )
}
