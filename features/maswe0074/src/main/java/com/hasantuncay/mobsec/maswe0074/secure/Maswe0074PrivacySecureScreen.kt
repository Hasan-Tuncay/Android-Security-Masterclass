package com.hasantuncay.mobsec.maswe0074.secure

import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Vector
import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Mitigation
import com.hasantuncay.mobsec.maswe0074.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0074PrivacySecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0074Mitigation.meta,
        vectors = Maswe0074Mitigation.entries,
        onBack = onBack
    )
}
