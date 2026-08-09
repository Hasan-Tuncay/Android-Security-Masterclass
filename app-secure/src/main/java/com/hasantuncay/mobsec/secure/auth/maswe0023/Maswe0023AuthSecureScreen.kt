package com.hasantuncay.mobsec.secure.auth.maswe0023

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0023Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0023AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0023Mitigation.entries,
        onBack = onBack
    )
}
