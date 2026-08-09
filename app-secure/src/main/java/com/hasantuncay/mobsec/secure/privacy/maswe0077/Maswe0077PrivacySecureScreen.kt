package com.hasantuncay.mobsec.secure.privacy.maswe0077

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0077Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0077PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0077Mitigation.meta,
        vectors = Maswe0077Mitigation.entries,
        onBack = onBack
    )
}
