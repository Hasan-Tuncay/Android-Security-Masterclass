package com.hasantuncay.mobsec.maswe0016.secure

import com.hasantuncay.mobsec.maswe0016.common.Maswe0016Vector
import com.hasantuncay.mobsec.maswe0016.common.Maswe0016Mitigation
import com.hasantuncay.mobsec.maswe0016.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0016CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0016Mitigation.meta,
        vectors = Maswe0016Mitigation.entries,
        onBack = onBack
    )
}
