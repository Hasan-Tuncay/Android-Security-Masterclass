package com.hasantuncay.mobsec.maswe0029.secure

import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Vector
import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Mitigation
import com.hasantuncay.mobsec.maswe0029.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0029PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0029Mitigation.meta,
        vectors = Maswe0029Mitigation.entries,
        onBack = onBack
    )
}
