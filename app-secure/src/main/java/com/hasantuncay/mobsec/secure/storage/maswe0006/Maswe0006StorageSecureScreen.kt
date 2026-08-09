package com.hasantuncay.mobsec.secure.storage.maswe0006

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.storage.Maswe0006Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0006StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0006Mitigation.meta,
        vectors = Maswe0006Mitigation.entries,
        onBack = onBack
    )
}
