package com.hasantuncay.mobsec.maswe0051.secure

import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Vector
import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Mitigation
import com.hasantuncay.mobsec.maswe0051.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0051ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0051Mitigation.meta,
        vectors = Maswe0051Mitigation.entries,
        onBack = onBack
    )
}
