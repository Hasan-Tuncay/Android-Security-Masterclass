package com.hasantuncay.mobsec.secure.privacy.maswe0070

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0070Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0070PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0070Mitigation.meta,
        vectors = Maswe0070Mitigation.entries,
        onBack = onBack
    )
}
