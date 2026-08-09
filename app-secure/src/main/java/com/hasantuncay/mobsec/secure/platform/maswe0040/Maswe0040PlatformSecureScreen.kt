package com.hasantuncay.mobsec.secure.platform.maswe0040

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0040Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0040PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0040Mitigation.meta,
        vectors = Maswe0040Mitigation.entries,
        onBack = onBack
    )
}
