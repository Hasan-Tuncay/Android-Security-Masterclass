package com.hasantuncay.mobsec.maswe0057.secure

import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Vector
import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Mitigation
import com.hasantuncay.mobsec.maswe0057.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0057ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0057Mitigation.meta,
        vectors = Maswe0057Mitigation.entries,
        onBack = onBack
    )
}
