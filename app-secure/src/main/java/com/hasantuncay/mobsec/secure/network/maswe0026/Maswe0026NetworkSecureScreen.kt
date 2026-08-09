package com.hasantuncay.mobsec.secure.network.maswe0026

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0026Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0026NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0026Mitigation.meta,
        vectors = Maswe0026Mitigation.entries,
        onBack = onBack
    )
}
