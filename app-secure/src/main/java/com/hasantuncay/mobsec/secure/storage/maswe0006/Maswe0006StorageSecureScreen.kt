package com.hasantuncay.mobsec.secure.storage.maswe0006

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0006Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0006StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        vectors = Maswe0006Mitigation.entries,
        onBack = onBack
    )
}
