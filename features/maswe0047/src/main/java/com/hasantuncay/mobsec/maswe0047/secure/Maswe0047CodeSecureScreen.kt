package com.hasantuncay.mobsec.maswe0047.secure

import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Vector
import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Mitigation
import com.hasantuncay.mobsec.maswe0047.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0047CodeSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0047Mitigation.meta,
        vectors = Maswe0047Mitigation.entries,
        onBack = onBack
    )
}
