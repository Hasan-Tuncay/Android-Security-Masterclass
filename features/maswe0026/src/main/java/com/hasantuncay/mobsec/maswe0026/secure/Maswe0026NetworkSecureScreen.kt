package com.hasantuncay.mobsec.maswe0026.secure

import com.hasantuncay.mobsec.maswe0026.common.Maswe0026Vector
import com.hasantuncay.mobsec.maswe0026.common.Maswe0026Mitigation
import com.hasantuncay.mobsec.maswe0026.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0026NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0026Mitigation.meta,
        vectors = Maswe0026Mitigation.entries,
        onBack = onBack
    )
}
