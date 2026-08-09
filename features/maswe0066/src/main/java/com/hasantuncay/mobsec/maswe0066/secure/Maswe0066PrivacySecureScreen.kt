package com.hasantuncay.mobsec.maswe0066.secure

import com.hasantuncay.mobsec.maswe0066.common.Maswe0066Vector
import com.hasantuncay.mobsec.maswe0066.common.Maswe0066Mitigation
import com.hasantuncay.mobsec.maswe0066.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0066PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0066Mitigation.meta,
        vectors = Maswe0066Mitigation.entries,
        onBack = onBack
    )
}
