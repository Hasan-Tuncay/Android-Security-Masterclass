package com.hasantuncay.mobsec.maswe0024.secure

import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Vector
import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Mitigation
import com.hasantuncay.mobsec.maswe0024.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0024AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0024Mitigation.meta,
        vectors = Maswe0024Mitigation.entries,
        onBack = onBack
    )
}
