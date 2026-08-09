package com.hasantuncay.mobsec.secure.privacy.maswe0073

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0073Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0073PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0073Mitigation.meta,
        vectors = Maswe0073Mitigation.entries,
        onBack = onBack
    )
}
