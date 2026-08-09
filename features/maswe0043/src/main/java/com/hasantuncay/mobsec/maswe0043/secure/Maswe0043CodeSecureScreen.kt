package com.hasantuncay.mobsec.maswe0043.secure

import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Vector
import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Mitigation
import com.hasantuncay.mobsec.maswe0043.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0043CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0043Mitigation.meta,
        vectors = Maswe0043Mitigation.entries,
        onBack = onBack
    )
}
