package com.hasantuncay.mobsec.maswe0007.secure

import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Mitigation
import com.hasantuncay.mobsec.maswe0007.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0007CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0007Mitigation.meta,
        vectors = Maswe0007Mitigation.entries,
        onBack = onBack
    )
}
