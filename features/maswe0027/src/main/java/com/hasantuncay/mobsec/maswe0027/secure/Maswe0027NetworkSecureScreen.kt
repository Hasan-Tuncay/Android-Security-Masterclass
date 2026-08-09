package com.hasantuncay.mobsec.maswe0027.secure

import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Vector
import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Mitigation
import com.hasantuncay.mobsec.maswe0027.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0027NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0027Mitigation.meta,
        vectors = Maswe0027Mitigation.entries,
        onBack = onBack
    )
}
