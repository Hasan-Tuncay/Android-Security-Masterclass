package com.hasantuncay.mobsec.secure.privacy.maswe0076

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0076Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0076PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0076Mitigation.meta,
        vectors = Maswe0076Mitigation.entries,
        onBack = onBack
    )
}
