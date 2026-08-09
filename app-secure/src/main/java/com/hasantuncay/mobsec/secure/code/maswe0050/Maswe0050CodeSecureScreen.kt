package com.hasantuncay.mobsec.secure.code.maswe0050

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0050Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0050CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0050Mitigation.meta,
        vectors = Maswe0050Mitigation.entries,
        onBack = onBack
    )
}
