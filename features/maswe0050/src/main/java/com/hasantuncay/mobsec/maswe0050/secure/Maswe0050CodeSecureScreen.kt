package com.hasantuncay.mobsec.maswe0050.secure

import com.hasantuncay.mobsec.maswe0050.common.Maswe0050Vector
import com.hasantuncay.mobsec.maswe0050.common.Maswe0050Mitigation
import com.hasantuncay.mobsec.maswe0050.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0050CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0050Mitigation.meta,
        vectors = Maswe0050Mitigation.entries,
        onBack = onBack
    )
}
