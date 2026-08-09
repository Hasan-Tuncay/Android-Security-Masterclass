package com.hasantuncay.mobsec.maswe0017.secure

import com.hasantuncay.mobsec.maswe0017.common.Maswe0017Vector
import com.hasantuncay.mobsec.maswe0017.common.Maswe0017Mitigation
import com.hasantuncay.mobsec.maswe0017.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0017CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0017Mitigation.meta,
        vectors = Maswe0017Mitigation.entries,
        onBack = onBack
    )
}
