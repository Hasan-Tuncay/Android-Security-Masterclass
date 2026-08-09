package com.hasantuncay.mobsec.maswe0009.secure

import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Vector
import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Mitigation
import com.hasantuncay.mobsec.maswe0009.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0009CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0009Mitigation.meta,
        vectors = Maswe0009Mitigation.entries,
        onBack = onBack
    )
}
