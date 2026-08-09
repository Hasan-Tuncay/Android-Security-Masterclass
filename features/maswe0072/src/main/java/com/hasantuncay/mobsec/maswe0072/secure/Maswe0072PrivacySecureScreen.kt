package com.hasantuncay.mobsec.maswe0072.secure

import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Vector
import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Mitigation
import com.hasantuncay.mobsec.maswe0072.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0072PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0072Mitigation.meta,
        vectors = Maswe0072Mitigation.entries,
        onBack = onBack
    )
}
