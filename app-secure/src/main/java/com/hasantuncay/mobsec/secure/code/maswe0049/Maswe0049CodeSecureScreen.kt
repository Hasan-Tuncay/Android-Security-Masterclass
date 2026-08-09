package com.hasantuncay.mobsec.secure.code.maswe0049

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0049Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0049CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0049Mitigation.meta,
        vectors = Maswe0049Mitigation.entries,
        onBack = onBack
    )
}
