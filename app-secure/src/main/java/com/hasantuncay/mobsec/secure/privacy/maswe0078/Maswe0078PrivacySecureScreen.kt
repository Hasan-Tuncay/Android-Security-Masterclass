package com.hasantuncay.mobsec.secure.privacy.maswe0078

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0078Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0078PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0078Mitigation.meta,
        vectors = Maswe0078Mitigation.entries,
        onBack = onBack
    )
}
