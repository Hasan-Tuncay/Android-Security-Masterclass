package com.hasantuncay.mobsec.secure.auth.maswe0024

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0024Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0024AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0024Mitigation.meta,
        vectors = Maswe0024Mitigation.entries,
        onBack = onBack
    )
}
