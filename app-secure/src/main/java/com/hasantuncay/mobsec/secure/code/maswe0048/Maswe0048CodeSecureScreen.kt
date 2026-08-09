package com.hasantuncay.mobsec.secure.code.maswe0048

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0048Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0048CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0048Mitigation.entries,
        onBack = onBack
    )
}
