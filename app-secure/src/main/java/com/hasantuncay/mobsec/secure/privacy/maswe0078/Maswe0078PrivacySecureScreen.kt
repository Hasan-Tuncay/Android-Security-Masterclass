package com.hasantuncay.mobsec.secure.privacy.maswe0078

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0078Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0078PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0078Mitigation.entries,
        onBack = onBack
    )
}
