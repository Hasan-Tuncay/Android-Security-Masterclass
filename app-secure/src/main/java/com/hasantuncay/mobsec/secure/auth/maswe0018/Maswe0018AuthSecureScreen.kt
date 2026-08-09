package com.hasantuncay.mobsec.secure.auth.maswe0018

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0018Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0018AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0018Mitigation.meta,
        vectors = Maswe0018Mitigation.entries,
        onBack = onBack
    )
}
