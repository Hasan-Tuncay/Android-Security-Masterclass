package com.hasantuncay.mobsec.maswe0030.secure

import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Vector
import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Mitigation
import com.hasantuncay.mobsec.maswe0030.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0030PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0030Mitigation.meta,
        vectors = Maswe0030Mitigation.entries,
        onBack = onBack
    )
}
