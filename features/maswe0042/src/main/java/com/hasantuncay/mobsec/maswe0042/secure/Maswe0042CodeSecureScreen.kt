package com.hasantuncay.mobsec.maswe0042.secure

import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Vector
import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Mitigation
import com.hasantuncay.mobsec.maswe0042.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0042CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0042Mitigation.meta,
        vectors = Maswe0042Mitigation.entries,
        onBack = onBack
    )
}
