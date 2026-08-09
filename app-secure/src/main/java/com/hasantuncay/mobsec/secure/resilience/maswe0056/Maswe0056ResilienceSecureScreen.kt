package com.hasantuncay.mobsec.secure.resilience.maswe0056

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0056Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0056ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0056Mitigation.entries,
        onBack = onBack
    )
}
