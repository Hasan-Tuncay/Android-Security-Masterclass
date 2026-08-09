package com.hasantuncay.mobsec.maswe0023.secure

import com.hasantuncay.mobsec.maswe0023.common.Maswe0023Vector
import com.hasantuncay.mobsec.maswe0023.common.Maswe0023Mitigation
import com.hasantuncay.mobsec.maswe0023.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0023AuthSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0023Mitigation.meta,
        vectors = Maswe0023Mitigation.entries,
        onBack = onBack
    )
}
