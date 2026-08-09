package com.hasantuncay.mobsec.secure.platform.maswe0038

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0038Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0038PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0038Mitigation.entries,
        onBack = onBack
    )
}
