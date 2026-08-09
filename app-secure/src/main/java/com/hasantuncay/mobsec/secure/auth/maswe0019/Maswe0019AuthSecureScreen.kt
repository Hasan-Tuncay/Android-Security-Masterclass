package com.hasantuncay.mobsec.secure.auth.maswe0019

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0019Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0019AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0019Mitigation.meta,
        vectors = Maswe0019Mitigation.entries,
        onBack = onBack
    )
}
