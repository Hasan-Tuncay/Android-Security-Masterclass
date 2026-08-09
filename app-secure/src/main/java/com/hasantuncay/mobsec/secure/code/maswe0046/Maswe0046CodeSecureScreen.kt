package com.hasantuncay.mobsec.secure.code.maswe0046

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0046Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0046CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0046Mitigation.entries,
        onBack = onBack
    )
}
