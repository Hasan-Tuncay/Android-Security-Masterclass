package com.hasantuncay.mobsec.maswe0035.secure

import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Vector
import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Mitigation
import com.hasantuncay.mobsec.maswe0035.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0035PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0035Mitigation.meta,
        vectors = Maswe0035Mitigation.entries,
        onBack = onBack
    )
}
