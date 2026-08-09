package com.hasantuncay.mobsec.maswe0048.secure

import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Vector
import com.hasantuncay.mobsec.maswe0048.common.Maswe0048Mitigation
import com.hasantuncay.mobsec.maswe0048.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0048CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0048Mitigation.meta,
        vectors = Maswe0048Mitigation.entries,
        onBack = onBack
    )
}
