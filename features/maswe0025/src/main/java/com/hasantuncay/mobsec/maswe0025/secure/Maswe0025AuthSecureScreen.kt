package com.hasantuncay.mobsec.maswe0025.secure

import com.hasantuncay.mobsec.maswe0025.common.Maswe0025Vector
import com.hasantuncay.mobsec.maswe0025.common.Maswe0025Mitigation
import com.hasantuncay.mobsec.maswe0025.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0025AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0025Mitigation.meta,
        vectors = Maswe0025Mitigation.entries,
        onBack = onBack
    )
}
