package com.hasantuncay.mobsec.maswe0033.secure

import com.hasantuncay.mobsec.maswe0033.common.Maswe0033Vector
import com.hasantuncay.mobsec.maswe0033.common.Maswe0033Mitigation
import com.hasantuncay.mobsec.maswe0033.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0033PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0033Mitigation.meta,
        vectors = Maswe0033Mitigation.entries,
        onBack = onBack
    )
}
