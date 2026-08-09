package com.hasantuncay.mobsec.maswe0052.secure

import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Vector
import com.hasantuncay.mobsec.maswe0052.common.Maswe0052Mitigation
import com.hasantuncay.mobsec.maswe0052.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0052ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0052Mitigation.meta,
        vectors = Maswe0052Mitigation.entries,
        onBack = onBack
    )
}
