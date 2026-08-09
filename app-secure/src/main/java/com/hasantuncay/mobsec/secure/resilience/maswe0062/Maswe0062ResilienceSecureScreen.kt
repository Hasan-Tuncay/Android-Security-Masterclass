package com.hasantuncay.mobsec.secure.resilience.maswe0062

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0062Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0062ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0062Mitigation.entries,
        onBack = onBack
    )
}
