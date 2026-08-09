package com.hasantuncay.mobsec.secure.resilience.maswe0055

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0055Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0055ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0055Mitigation.meta,
        vectors = Maswe0055Mitigation.entries,
        onBack = onBack
    )
}
