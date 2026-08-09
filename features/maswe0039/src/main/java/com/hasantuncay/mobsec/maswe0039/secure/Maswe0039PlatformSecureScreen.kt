package com.hasantuncay.mobsec.maswe0039.secure

import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Vector
import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Mitigation
import com.hasantuncay.mobsec.maswe0039.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0039PlatformSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0039Mitigation.meta,
        vectors = Maswe0039Mitigation.entries,
        onBack = onBack
    )
}
