package com.hasantuncay.mobsec.secure.platform.maswe0031

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0031Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0031PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0031Mitigation.meta,
        vectors = Maswe0031Mitigation.entries,
        onBack = onBack
    )
}
