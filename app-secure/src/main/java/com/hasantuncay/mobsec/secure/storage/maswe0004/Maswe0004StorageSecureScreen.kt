package com.hasantuncay.mobsec.secure.storage.maswe0004

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0004Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0004StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0004Mitigation.entries,
        onBack = onBack
    )
}
