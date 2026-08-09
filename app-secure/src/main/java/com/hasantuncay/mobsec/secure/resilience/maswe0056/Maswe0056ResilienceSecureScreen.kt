package com.hasantuncay.mobsec.secure.resilience.maswe0056

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.resilience.Maswe0056Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0056ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0056Mitigation.meta,
        vectors = Maswe0056Mitigation.entries,
        onBack = onBack
    )
}
