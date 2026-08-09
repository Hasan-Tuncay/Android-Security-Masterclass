package com.hasantuncay.mobsec.maswe0004.secure

import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation
import com.hasantuncay.mobsec.maswe0004.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0004StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0004Mitigation.meta,
        vectors = Maswe0004Mitigation.entries,
        onBack = onBack
    )
}
