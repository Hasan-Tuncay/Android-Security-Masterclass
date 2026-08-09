package com.hasantuncay.mobsec.maswe0078.secure

import com.hasantuncay.mobsec.maswe0078.common.Maswe0078Vector
import com.hasantuncay.mobsec.maswe0078.common.Maswe0078Mitigation
import com.hasantuncay.mobsec.maswe0078.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0078PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0078Mitigation.meta,
        vectors = Maswe0078Mitigation.entries,
        onBack = onBack
    )
}
