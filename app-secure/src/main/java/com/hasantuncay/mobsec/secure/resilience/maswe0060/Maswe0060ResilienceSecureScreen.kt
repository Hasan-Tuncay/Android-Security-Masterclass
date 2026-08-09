package com.hasantuncay.mobsec.secure.resilience.maswe0060

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0060Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0060ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0060Mitigation.meta,
        vectors = Maswe0060Mitigation.entries,
        onBack = onBack
    )
}
