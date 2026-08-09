package com.hasantuncay.mobsec.maswe0071.secure

import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Vector
import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Mitigation
import com.hasantuncay.mobsec.maswe0071.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0071PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0071Mitigation.meta,
        vectors = Maswe0071Mitigation.entries,
        onBack = onBack
    )
}
