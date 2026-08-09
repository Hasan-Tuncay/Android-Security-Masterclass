package com.hasantuncay.mobsec.maswe0045.secure

import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Vector
import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Mitigation
import com.hasantuncay.mobsec.maswe0045.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0045CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0045Mitigation.meta,
        vectors = Maswe0045Mitigation.entries,
        onBack = onBack
    )
}
