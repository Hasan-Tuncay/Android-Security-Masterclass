package com.hasantuncay.mobsec.maswe0034.secure

import com.hasantuncay.mobsec.maswe0034.common.Maswe0034Vector
import com.hasantuncay.mobsec.maswe0034.common.Maswe0034Mitigation
import com.hasantuncay.mobsec.maswe0034.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0034PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0034Mitigation.meta,
        vectors = Maswe0034Mitigation.entries,
        onBack = onBack
    )
}
