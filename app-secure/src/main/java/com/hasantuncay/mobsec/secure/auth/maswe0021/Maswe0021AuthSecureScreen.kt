package com.hasantuncay.mobsec.secure.auth.maswe0021

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0021Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0021AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0021Mitigation.meta,
        vectors = Maswe0021Mitigation.entries,
        onBack = onBack
    )
}
