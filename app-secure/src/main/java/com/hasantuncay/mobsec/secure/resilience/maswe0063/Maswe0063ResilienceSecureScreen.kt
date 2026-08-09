package com.hasantuncay.mobsec.secure.resilience.maswe0063

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0063Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0063ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0063Mitigation.entries,
        onBack = onBack
    )
}
