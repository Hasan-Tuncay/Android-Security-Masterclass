package com.hasantuncay.mobsec.secure.platform.maswe0036

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0036Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0036PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0036Mitigation.entries,
        onBack = onBack
    )
}
