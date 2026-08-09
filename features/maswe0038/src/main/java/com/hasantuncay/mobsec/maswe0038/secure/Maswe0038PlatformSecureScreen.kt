package com.hasantuncay.mobsec.maswe0038.secure

import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Vector
import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Mitigation
import com.hasantuncay.mobsec.maswe0038.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0038PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0038Mitigation.meta,
        vectors = Maswe0038Mitigation.entries,
        onBack = onBack
    )
}
