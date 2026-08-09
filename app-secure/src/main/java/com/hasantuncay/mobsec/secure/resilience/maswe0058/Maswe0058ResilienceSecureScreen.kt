package com.hasantuncay.mobsec.secure.resilience.maswe0058

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0058Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0058ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0058Mitigation.entries,
        onBack = onBack
    )
}
