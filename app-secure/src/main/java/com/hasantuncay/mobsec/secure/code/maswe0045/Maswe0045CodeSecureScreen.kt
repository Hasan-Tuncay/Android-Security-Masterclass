package com.hasantuncay.mobsec.secure.code.maswe0045

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0045Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0045CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0045Mitigation.meta,
        vectors = Maswe0045Mitigation.entries,
        onBack = onBack
    )
}
