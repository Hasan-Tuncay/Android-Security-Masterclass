package com.hasantuncay.mobsec.secure.auth.maswe0022

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0022Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0022AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0022Mitigation.meta,
        vectors = Maswe0022Mitigation.entries,
        onBack = onBack
    )
}
