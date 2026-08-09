package com.hasantuncay.mobsec.maswe0062.secure

import com.hasantuncay.mobsec.maswe0062.common.Maswe0062Vector
import com.hasantuncay.mobsec.maswe0062.common.Maswe0062Mitigation
import com.hasantuncay.mobsec.maswe0062.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0062ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0062Mitigation.meta,
        vectors = Maswe0062Mitigation.entries,
        onBack = onBack
    )
}
