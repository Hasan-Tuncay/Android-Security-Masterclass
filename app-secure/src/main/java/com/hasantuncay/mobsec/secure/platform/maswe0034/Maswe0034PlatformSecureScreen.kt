package com.hasantuncay.mobsec.secure.platform.maswe0034

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0034Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0034PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0034Mitigation.meta,
        vectors = Maswe0034Mitigation.entries,
        onBack = onBack
    )
}
