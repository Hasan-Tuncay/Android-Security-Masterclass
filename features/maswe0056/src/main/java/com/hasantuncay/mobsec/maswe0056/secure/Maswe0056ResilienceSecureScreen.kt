package com.hasantuncay.mobsec.maswe0056.secure

import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Vector
import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Mitigation
import com.hasantuncay.mobsec.maswe0056.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0056ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0056Mitigation.meta,
        vectors = Maswe0056Mitigation.entries,
        onBack = onBack
    )
}
