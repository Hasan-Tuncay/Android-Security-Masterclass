package com.hasantuncay.mobsec.maswe0061.secure

import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Vector
import com.hasantuncay.mobsec.maswe0061.common.Maswe0061Mitigation
import com.hasantuncay.mobsec.maswe0061.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0061ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0061Mitigation.meta,
        vectors = Maswe0061Mitigation.entries,
        onBack = onBack
    )
}
