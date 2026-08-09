package com.hasantuncay.mobsec.maswe0055.secure

import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Vector
import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Mitigation
import com.hasantuncay.mobsec.maswe0055.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0055ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0055Mitigation.meta,
        vectors = Maswe0055Mitigation.entries,
        onBack = onBack
    )
}
