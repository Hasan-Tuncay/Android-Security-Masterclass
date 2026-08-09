package com.hasantuncay.mobsec.secure.privacy.maswe0066

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0066Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0066PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0066Mitigation.entries,
        onBack = onBack
    )
}
