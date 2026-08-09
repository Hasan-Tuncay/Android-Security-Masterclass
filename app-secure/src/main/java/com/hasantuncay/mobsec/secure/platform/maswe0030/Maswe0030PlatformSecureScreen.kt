package com.hasantuncay.mobsec.secure.platform.maswe0030

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0030Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0030PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0030Mitigation.meta,
        vectors = Maswe0030Mitigation.entries,
        onBack = onBack
    )
}
