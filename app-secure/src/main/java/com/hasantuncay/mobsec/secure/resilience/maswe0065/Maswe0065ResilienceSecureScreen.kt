package com.hasantuncay.mobsec.secure.resilience.maswe0065

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0065Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0065ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0065Mitigation.entries,
        onBack = onBack
    )
}
