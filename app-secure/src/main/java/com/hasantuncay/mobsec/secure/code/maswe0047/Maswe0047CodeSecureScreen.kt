package com.hasantuncay.mobsec.secure.code.maswe0047

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0047Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0047CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0047Mitigation.entries,
        onBack = onBack
    )
}
