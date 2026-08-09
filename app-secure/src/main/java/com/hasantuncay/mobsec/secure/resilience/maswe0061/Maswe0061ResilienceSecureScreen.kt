package com.hasantuncay.mobsec.secure.resilience.maswe0061

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0061Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0061ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0061Mitigation.meta,
        vectors = Maswe0061Mitigation.entries,
        onBack = onBack
    )
}
