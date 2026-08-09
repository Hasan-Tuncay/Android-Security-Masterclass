package com.hasantuncay.mobsec.secure.privacy.maswe0074

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0074Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0074PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0074Mitigation.entries,
        onBack = onBack
    )
}
