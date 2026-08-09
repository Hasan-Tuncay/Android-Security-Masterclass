package com.hasantuncay.mobsec.maswe0015.secure

import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Vector
import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Mitigation
import com.hasantuncay.mobsec.maswe0015.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0015CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0015Mitigation.meta,
        vectors = Maswe0015Mitigation.entries,
        onBack = onBack
    )
}
