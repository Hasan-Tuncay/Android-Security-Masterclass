package com.hasantuncay.mobsec.secure.auth.maswe0020

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0020Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0020AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0020Mitigation.entries,
        onBack = onBack
    )
}
