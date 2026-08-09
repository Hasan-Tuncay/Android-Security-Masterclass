package com.hasantuncay.mobsec.maswe0076.secure

import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Vector
import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Mitigation
import com.hasantuncay.mobsec.maswe0076.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0076PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0076Mitigation.meta,
        vectors = Maswe0076Mitigation.entries,
        onBack = onBack
    )
}
