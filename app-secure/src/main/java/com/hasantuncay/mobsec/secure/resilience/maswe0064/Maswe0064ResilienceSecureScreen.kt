package com.hasantuncay.mobsec.secure.resilience.maswe0064

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0064Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0064ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0064Mitigation.meta,
        vectors = Maswe0064Mitigation.entries,
        onBack = onBack
    )
}
