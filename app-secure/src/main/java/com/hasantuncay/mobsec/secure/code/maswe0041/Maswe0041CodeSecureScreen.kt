package com.hasantuncay.mobsec.secure.code.maswe0041

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0041Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0041CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0041Mitigation.entries,
        onBack = onBack
    )
}
