package com.hasantuncay.mobsec.secure.auth.maswe0025

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0025Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0025AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0025Mitigation.entries,
        onBack = onBack
    )
}
