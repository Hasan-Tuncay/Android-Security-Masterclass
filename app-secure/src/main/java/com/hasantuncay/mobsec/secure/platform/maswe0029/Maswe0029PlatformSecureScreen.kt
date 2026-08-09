package com.hasantuncay.mobsec.secure.platform.maswe0029

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0029Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0029PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0029Mitigation.meta,
        vectors = Maswe0029Mitigation.entries,
        onBack = onBack
    )
}
