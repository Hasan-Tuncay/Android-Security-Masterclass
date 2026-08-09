package com.hasantuncay.mobsec.maswe0003.secure

import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import com.hasantuncay.mobsec.maswe0003.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0003StorageSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0003Mitigation.meta,
        vectors = Maswe0003Mitigation.entries,
        onBack = onBack
    )
}
