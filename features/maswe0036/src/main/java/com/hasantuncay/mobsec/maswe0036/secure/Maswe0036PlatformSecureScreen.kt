package com.hasantuncay.mobsec.maswe0036.secure

import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Vector
import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Mitigation
import com.hasantuncay.mobsec.maswe0036.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0036PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0036Mitigation.meta,
        vectors = Maswe0036Mitigation.entries,
        onBack = onBack
    )
}
