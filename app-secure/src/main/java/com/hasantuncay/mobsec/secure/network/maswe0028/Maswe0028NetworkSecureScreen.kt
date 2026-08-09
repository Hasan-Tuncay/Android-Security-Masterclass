package com.hasantuncay.mobsec.secure.network.maswe0028

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0028Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0028NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0028Mitigation.meta,
        vectors = Maswe0028Mitigation.entries,
        onBack = onBack
    )
}
