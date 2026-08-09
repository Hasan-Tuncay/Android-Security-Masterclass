package com.hasantuncay.mobsec.secure.platform.maswe0039

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0039Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0039PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0039Mitigation.entries,
        onBack = onBack
    )
}
