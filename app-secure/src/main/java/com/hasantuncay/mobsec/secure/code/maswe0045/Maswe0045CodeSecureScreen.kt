package com.hasantuncay.mobsec.secure.code.maswe0045

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0045Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0045CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0045Mitigation.entries,
        onBack = onBack
    )
}
