package com.hasantuncay.mobsec.secure.network.maswe0027

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0027Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0027NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0027Mitigation.meta,
        vectors = Maswe0027Mitigation.entries,
        onBack = onBack
    )
}
