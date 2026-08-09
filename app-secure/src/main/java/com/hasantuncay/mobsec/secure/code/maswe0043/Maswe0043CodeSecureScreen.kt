package com.hasantuncay.mobsec.secure.code.maswe0043

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0043Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0043CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0043Mitigation.meta,
        vectors = Maswe0043Mitigation.entries,
        onBack = onBack
    )
}
