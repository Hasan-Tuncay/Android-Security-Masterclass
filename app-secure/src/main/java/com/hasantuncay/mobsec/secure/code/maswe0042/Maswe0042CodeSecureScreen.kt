package com.hasantuncay.mobsec.secure.code.maswe0042

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0042Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0042CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0042Mitigation.entries,
        onBack = onBack
    )
}
