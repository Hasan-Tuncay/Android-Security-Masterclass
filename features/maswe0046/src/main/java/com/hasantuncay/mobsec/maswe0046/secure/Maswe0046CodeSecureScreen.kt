package com.hasantuncay.mobsec.maswe0046.secure

import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Vector
import com.hasantuncay.mobsec.maswe0046.common.Maswe0046Mitigation
import com.hasantuncay.mobsec.maswe0046.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0046CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0046Mitigation.meta,
        vectors = Maswe0046Mitigation.entries,
        onBack = onBack
    )
}
