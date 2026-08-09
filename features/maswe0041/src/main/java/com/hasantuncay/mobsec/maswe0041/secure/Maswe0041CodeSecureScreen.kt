package com.hasantuncay.mobsec.maswe0041.secure

import com.hasantuncay.mobsec.maswe0041.common.Maswe0041Vector
import com.hasantuncay.mobsec.maswe0041.common.Maswe0041Mitigation
import com.hasantuncay.mobsec.maswe0041.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0041CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0041Mitigation.meta,
        vectors = Maswe0041Mitigation.entries,
        onBack = onBack
    )
}
