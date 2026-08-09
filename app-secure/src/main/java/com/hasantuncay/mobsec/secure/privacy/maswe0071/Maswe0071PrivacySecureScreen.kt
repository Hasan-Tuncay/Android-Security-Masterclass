package com.hasantuncay.mobsec.secure.privacy.maswe0071

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0071Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0071PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0071Mitigation.entries,
        onBack = onBack
    )
}
