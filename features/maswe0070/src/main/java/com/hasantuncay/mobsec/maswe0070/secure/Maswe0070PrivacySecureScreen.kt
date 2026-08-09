package com.hasantuncay.mobsec.maswe0070.secure

import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Vector
import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Mitigation
import com.hasantuncay.mobsec.maswe0070.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0070PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0070Mitigation.meta,
        vectors = Maswe0070Mitigation.entries,
        onBack = onBack
    )
}
