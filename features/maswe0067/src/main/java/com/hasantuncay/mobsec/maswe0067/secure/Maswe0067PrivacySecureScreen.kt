package com.hasantuncay.mobsec.maswe0067.secure

import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Vector
import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Mitigation
import com.hasantuncay.mobsec.maswe0067.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0067PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0067Mitigation.meta,
        vectors = Maswe0067Mitigation.entries,
        onBack = onBack
    )
}
