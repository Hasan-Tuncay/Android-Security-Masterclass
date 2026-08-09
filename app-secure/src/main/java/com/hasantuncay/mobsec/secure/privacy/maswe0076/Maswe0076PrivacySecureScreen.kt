package com.hasantuncay.mobsec.secure.privacy.maswe0076

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0076Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0076PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0076Mitigation.entries,
        onBack = onBack
    )
}
