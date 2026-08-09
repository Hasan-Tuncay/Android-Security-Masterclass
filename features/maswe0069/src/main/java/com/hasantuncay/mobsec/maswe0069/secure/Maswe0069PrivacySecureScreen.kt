package com.hasantuncay.mobsec.maswe0069.secure

import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Vector
import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Mitigation
import com.hasantuncay.mobsec.maswe0069.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0069PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0069Mitigation.meta,
        vectors = Maswe0069Mitigation.entries,
        onBack = onBack
    )
}
