package com.hasantuncay.mobsec.maswe0058.secure

import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Vector
import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Mitigation
import com.hasantuncay.mobsec.maswe0058.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0058ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0058Mitigation.meta,
        vectors = Maswe0058Mitigation.entries,
        onBack = onBack
    )
}
