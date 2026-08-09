package com.hasantuncay.mobsec.maswe0037.secure

import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Vector
import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Mitigation
import com.hasantuncay.mobsec.maswe0037.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0037PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0037Mitigation.meta,
        vectors = Maswe0037Mitigation.entries,
        onBack = onBack
    )
}
