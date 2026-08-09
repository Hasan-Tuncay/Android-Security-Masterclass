package com.hasantuncay.mobsec.maswe0049.secure

import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Vector
import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Mitigation
import com.hasantuncay.mobsec.maswe0049.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0049CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0049Mitigation.meta,
        vectors = Maswe0049Mitigation.entries,
        onBack = onBack
    )
}
