package com.hasantuncay.mobsec.maswe0031.secure

import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Vector
import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Mitigation
import com.hasantuncay.mobsec.maswe0031.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0031PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0031Mitigation.meta,
        vectors = Maswe0031Mitigation.entries,
        onBack = onBack
    )
}
