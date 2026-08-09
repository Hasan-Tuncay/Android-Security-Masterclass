package com.hasantuncay.mobsec.secure.platform.maswe0035

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0035Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0035PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0035Mitigation.entries,
        onBack = onBack
    )
}
