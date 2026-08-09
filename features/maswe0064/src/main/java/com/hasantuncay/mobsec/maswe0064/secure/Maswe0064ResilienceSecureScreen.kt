package com.hasantuncay.mobsec.maswe0064.secure

import com.hasantuncay.mobsec.maswe0064.common.Maswe0064Vector
import com.hasantuncay.mobsec.maswe0064.common.Maswe0064Mitigation
import com.hasantuncay.mobsec.maswe0064.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0064ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0064Mitigation.meta,
        vectors = Maswe0064Mitigation.entries,
        onBack = onBack
    )
}
