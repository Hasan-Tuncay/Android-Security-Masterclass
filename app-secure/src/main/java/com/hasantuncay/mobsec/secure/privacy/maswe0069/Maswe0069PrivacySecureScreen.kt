package com.hasantuncay.mobsec.secure.privacy.maswe0069

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0069Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0069PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0069Mitigation.entries,
        onBack = onBack
    )
}
