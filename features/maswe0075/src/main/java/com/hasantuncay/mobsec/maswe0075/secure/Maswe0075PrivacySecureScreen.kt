package com.hasantuncay.mobsec.maswe0075.secure

import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Vector
import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Mitigation
import com.hasantuncay.mobsec.maswe0075.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0075PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0075Mitigation.meta,
        vectors = Maswe0075Mitigation.entries,
        onBack = onBack
    )
}
