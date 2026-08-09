package com.hasantuncay.mobsec.secure.auth.maswe0021

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0021Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0021AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0021Mitigation.entries,
        onBack = onBack
    )
}
