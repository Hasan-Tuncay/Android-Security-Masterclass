package com.hasantuncay.mobsec.maswe0021.secure

import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Vector
import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Mitigation
import com.hasantuncay.mobsec.maswe0021.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0021AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0021Mitigation.meta,
        vectors = Maswe0021Mitigation.entries,
        onBack = onBack
    )
}
