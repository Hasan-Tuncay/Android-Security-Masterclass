package com.hasantuncay.mobsec.maswe0053.secure

import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Vector
import com.hasantuncay.mobsec.maswe0053.common.Maswe0053Mitigation
import com.hasantuncay.mobsec.maswe0053.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0053ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0053Mitigation.meta,
        vectors = Maswe0053Mitigation.entries,
        onBack = onBack
    )
}
