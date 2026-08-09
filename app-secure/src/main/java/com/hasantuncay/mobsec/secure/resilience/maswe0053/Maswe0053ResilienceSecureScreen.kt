package com.hasantuncay.mobsec.secure.resilience.maswe0053

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0053Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0053ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0053Mitigation.entries,
        onBack = onBack
    )
}
