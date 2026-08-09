package com.hasantuncay.mobsec.secure.privacy.maswe0075

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0075Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0075PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0075Mitigation.entries,
        onBack = onBack
    )
}
