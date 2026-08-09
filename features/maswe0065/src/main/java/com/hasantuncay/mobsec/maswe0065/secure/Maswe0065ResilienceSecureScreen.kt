package com.hasantuncay.mobsec.maswe0065.secure

import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Vector
import com.hasantuncay.mobsec.maswe0065.common.Maswe0065Mitigation
import com.hasantuncay.mobsec.maswe0065.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0065ResilienceSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0065Mitigation.meta,
        vectors = Maswe0065Mitigation.entries,
        onBack = onBack
    )
}
