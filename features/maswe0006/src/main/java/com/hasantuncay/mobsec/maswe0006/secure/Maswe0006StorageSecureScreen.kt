package com.hasantuncay.mobsec.maswe0006.secure

import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Vector
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation
import com.hasantuncay.mobsec.maswe0006.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0006StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0006Mitigation.meta,
        vectors = Maswe0006Mitigation.entries,
        onBack = onBack
    )
}
