package com.hasantuncay.mobsec.secure.resilience.maswe0059

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0059Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0059ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0059Mitigation.meta,
        vectors = Maswe0059Mitigation.entries,
        onBack = onBack
    )
}
