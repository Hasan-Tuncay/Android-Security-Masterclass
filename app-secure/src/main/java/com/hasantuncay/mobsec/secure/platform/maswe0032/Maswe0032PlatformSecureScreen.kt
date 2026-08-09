package com.hasantuncay.mobsec.secure.platform.maswe0032

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0032Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0032PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0032Mitigation.meta,
        vectors = Maswe0032Mitigation.entries,
        onBack = onBack
    )
}
