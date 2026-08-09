package com.hasantuncay.mobsec.maswe0068.secure

import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Vector
import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Mitigation
import com.hasantuncay.mobsec.maswe0068.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0068PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0068Mitigation.meta,
        vectors = Maswe0068Mitigation.entries,
        onBack = onBack
    )
}
