package com.hasantuncay.mobsec.maswe0060.secure

import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Vector
import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Mitigation
import com.hasantuncay.mobsec.maswe0060.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0060ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0060Mitigation.meta,
        vectors = Maswe0060Mitigation.entries,
        onBack = onBack
    )
}
