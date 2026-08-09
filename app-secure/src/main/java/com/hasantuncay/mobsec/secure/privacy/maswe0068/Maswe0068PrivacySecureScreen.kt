package com.hasantuncay.mobsec.secure.privacy.maswe0068

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0068Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0068PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0068Mitigation.meta,
        vectors = Maswe0068Mitigation.entries,
        onBack = onBack
    )
}
