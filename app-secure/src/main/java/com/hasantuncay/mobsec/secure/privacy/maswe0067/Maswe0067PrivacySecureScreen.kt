package com.hasantuncay.mobsec.secure.privacy.maswe0067

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0067Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0067PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0067Mitigation.meta,
        vectors = Maswe0067Mitigation.entries,
        onBack = onBack
    )
}
