package com.hasantuncay.mobsec.secure.resilience.maswe0062

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0062Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0062ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0062Mitigation.meta,
        vectors = Maswe0062Mitigation.entries,
        onBack = onBack
    )
}
