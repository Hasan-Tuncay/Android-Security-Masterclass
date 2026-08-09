package com.hasantuncay.mobsec.maswe0044.secure

import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Vector
import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Mitigation
import com.hasantuncay.mobsec.maswe0044.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0044CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0044Mitigation.meta,
        vectors = Maswe0044Mitigation.entries,
        onBack = onBack
    )
}
