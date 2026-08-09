package com.hasantuncay.mobsec.maswe0013.secure

import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Vector
import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Mitigation
import com.hasantuncay.mobsec.maswe0013.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0013CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0013Mitigation.meta,
        vectors = Maswe0013Mitigation.entries,
        onBack = onBack
    )
}
