package com.hasantuncay.mobsec.secure.privacy.maswe0071

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0071Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0071PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0071Mitigation.meta,
        vectors = Maswe0071Mitigation.entries,
        onBack = onBack
    )
}
