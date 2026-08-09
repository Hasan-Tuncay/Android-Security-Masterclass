package com.hasantuncay.mobsec.secure.platform.maswe0037

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0037Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0037PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0037Mitigation.entries,
        onBack = onBack
    )
}
