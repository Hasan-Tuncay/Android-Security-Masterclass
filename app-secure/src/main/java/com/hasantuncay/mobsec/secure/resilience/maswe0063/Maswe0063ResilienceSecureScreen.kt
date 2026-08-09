package com.hasantuncay.mobsec.secure.resilience.maswe0063

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0063Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0063ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0063Mitigation.meta,
        vectors = Maswe0063Mitigation.entries,
        onBack = onBack
    )
}
