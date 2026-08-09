package com.hasantuncay.mobsec.maswe0011.secure

import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Vector
import com.hasantuncay.mobsec.maswe0011.common.Maswe0011Mitigation
import com.hasantuncay.mobsec.maswe0011.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0011CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0011Mitigation.meta,
        vectors = Maswe0011Mitigation.entries,
        onBack = onBack
    )
}
