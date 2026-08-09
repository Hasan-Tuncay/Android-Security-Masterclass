package com.hasantuncay.mobsec.maswe0032.secure

import com.hasantuncay.mobsec.maswe0032.common.Maswe0032Vector
import com.hasantuncay.mobsec.maswe0032.common.Maswe0032Mitigation
import com.hasantuncay.mobsec.maswe0032.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0032PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0032Mitigation.meta,
        vectors = Maswe0032Mitigation.entries,
        onBack = onBack
    )
}
