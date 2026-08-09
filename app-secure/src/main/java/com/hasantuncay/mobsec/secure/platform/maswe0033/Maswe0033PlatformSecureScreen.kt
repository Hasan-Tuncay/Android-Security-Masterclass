package com.hasantuncay.mobsec.secure.platform.maswe0033

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0033Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0033PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0033Mitigation.entries,
        onBack = onBack
    )
}
