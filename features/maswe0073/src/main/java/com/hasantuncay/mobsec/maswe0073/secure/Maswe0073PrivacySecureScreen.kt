package com.hasantuncay.mobsec.maswe0073.secure

import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Vector
import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Mitigation
import com.hasantuncay.mobsec.maswe0073.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0073PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0073Mitigation.meta,
        vectors = Maswe0073Mitigation.entries,
        onBack = onBack
    )
}
