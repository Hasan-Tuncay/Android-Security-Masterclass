package com.hasantuncay.mobsec.secure.privacy.maswe0070

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0070Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0070PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0070Mitigation.entries,
        onBack = onBack
    )
}
