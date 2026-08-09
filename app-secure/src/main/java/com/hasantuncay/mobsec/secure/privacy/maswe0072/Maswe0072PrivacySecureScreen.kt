package com.hasantuncay.mobsec.secure.privacy.maswe0072

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0072Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0072PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0072Mitigation.meta,
        vectors = Maswe0072Mitigation.entries,
        onBack = onBack
    )
}
