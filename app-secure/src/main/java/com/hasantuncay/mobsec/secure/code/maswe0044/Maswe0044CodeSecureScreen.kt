package com.hasantuncay.mobsec.secure.code.maswe0044

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0044Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0044CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0044Mitigation.meta,
        vectors = Maswe0044Mitigation.entries,
        onBack = onBack
    )
}
