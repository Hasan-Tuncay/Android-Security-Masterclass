package com.hasantuncay.mobsec.maswe0010.secure

import com.hasantuncay.mobsec.maswe0010.common.Maswe0010Vector
import com.hasantuncay.mobsec.maswe0010.common.Maswe0010Mitigation
import com.hasantuncay.mobsec.maswe0010.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0010CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0010Mitigation.meta,
        vectors = Maswe0010Mitigation.entries,
        onBack = onBack
    )
}
