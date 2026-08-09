package com.hasantuncay.mobsec.maswe0022.secure

import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Vector
import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Mitigation
import com.hasantuncay.mobsec.maswe0022.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0022AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0022Mitigation.meta,
        vectors = Maswe0022Mitigation.entries,
        onBack = onBack
    )
}
