package com.hasantuncay.mobsec.maswe0063.secure

import com.hasantuncay.mobsec.maswe0063.common.Maswe0063Vector
import com.hasantuncay.mobsec.maswe0063.common.Maswe0063Mitigation
import com.hasantuncay.mobsec.maswe0063.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0063ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0063Mitigation.meta,
        vectors = Maswe0063Mitigation.entries,
        onBack = onBack
    )
}
