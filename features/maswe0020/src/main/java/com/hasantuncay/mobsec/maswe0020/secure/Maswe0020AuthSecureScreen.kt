package com.hasantuncay.mobsec.maswe0020.secure

import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Vector
import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Mitigation
import com.hasantuncay.mobsec.maswe0020.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0020AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0020Mitigation.meta,
        vectors = Maswe0020Mitigation.entries,
        onBack = onBack
    )
}
