package com.hasantuncay.mobsec.maswe0040.secure

import com.hasantuncay.mobsec.maswe0040.common.Maswe0040Vector
import com.hasantuncay.mobsec.maswe0040.common.Maswe0040Mitigation
import com.hasantuncay.mobsec.maswe0040.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0040PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0040Mitigation.meta,
        vectors = Maswe0040Mitigation.entries,
        onBack = onBack
    )
}
