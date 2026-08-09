package com.hasantuncay.mobsec.maswe0019.secure

import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Vector
import com.hasantuncay.mobsec.maswe0019.common.Maswe0019Mitigation
import com.hasantuncay.mobsec.maswe0019.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0019AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0019Mitigation.meta,
        vectors = Maswe0019Mitigation.entries,
        onBack = onBack
    )
}
