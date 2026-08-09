package com.hasantuncay.mobsec.maswe0059.secure

import com.hasantuncay.mobsec.maswe0059.common.Maswe0059Vector
import com.hasantuncay.mobsec.maswe0059.common.Maswe0059Mitigation
import com.hasantuncay.mobsec.maswe0059.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0059ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0059Mitigation.meta,
        vectors = Maswe0059Mitigation.entries,
        onBack = onBack
    )
}
