package com.hasantuncay.mobsec.maswe0008.secure

import com.hasantuncay.mobsec.maswe0008.common.Maswe0008Vector
import com.hasantuncay.mobsec.maswe0008.common.Maswe0008Mitigation
import com.hasantuncay.mobsec.maswe0008.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0008CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0008Mitigation.meta,
        vectors = Maswe0008Mitigation.entries,
        onBack = onBack
    )
}
