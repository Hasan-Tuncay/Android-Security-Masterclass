package com.hasantuncay.mobsec.secure.platform.maswe0039

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0039Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0039PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0039Mitigation.meta,
        vectors = Maswe0039Mitigation.entries,
        onBack = onBack
    )
}
