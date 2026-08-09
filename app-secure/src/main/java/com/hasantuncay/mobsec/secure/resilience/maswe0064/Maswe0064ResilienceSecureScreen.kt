package com.hasantuncay.mobsec.secure.resilience.maswe0064

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0064Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0064ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0064Mitigation.entries,
        onBack = onBack
    )
}
