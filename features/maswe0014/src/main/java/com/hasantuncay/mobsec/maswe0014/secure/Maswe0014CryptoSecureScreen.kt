package com.hasantuncay.mobsec.maswe0014.secure

import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Vector
import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Mitigation
import com.hasantuncay.mobsec.maswe0014.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0014CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0014Mitigation.meta,
        vectors = Maswe0014Mitigation.entries,
        onBack = onBack
    )
}
