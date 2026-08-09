package com.hasantuncay.mobsec.secure.resilience.maswe0054

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0054Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0054ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0054Mitigation.meta,
        vectors = Maswe0054Mitigation.entries,
        onBack = onBack
    )
}
