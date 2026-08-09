package com.hasantuncay.mobsec.secure.code.maswe0041

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0041Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0041CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0041Mitigation.meta,
        vectors = Maswe0041Mitigation.entries,
        onBack = onBack
    )
}
