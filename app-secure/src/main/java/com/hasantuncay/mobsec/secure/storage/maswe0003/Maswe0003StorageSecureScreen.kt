package com.hasantuncay.mobsec.secure.storage.maswe0003

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.storage.Maswe0003Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0003StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0003Mitigation.meta,
        vectors = Maswe0003Mitigation.entries,
        onBack = onBack
    )
}
