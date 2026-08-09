package com.hasantuncay.mobsec.maswe0012.secure

import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Vector
import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Mitigation
import com.hasantuncay.mobsec.maswe0012.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0012CryptoSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0012Mitigation.meta,
        vectors = Maswe0012Mitigation.entries,
        onBack = onBack
    )
}
