package com.hasantuncay.mobsec.maswe0054.secure

import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Vector
import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Mitigation
import com.hasantuncay.mobsec.maswe0054.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0054ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0054Mitigation.meta,
        vectors = Maswe0054Mitigation.entries,
        onBack = onBack
    )
}
