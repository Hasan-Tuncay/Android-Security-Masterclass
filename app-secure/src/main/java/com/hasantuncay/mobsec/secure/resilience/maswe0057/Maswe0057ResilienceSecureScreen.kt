package com.hasantuncay.mobsec.secure.resilience.maswe0057

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0057Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0057ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0057Mitigation.entries,
        onBack = onBack
    )
}
