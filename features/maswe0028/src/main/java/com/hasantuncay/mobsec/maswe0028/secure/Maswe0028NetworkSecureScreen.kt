package com.hasantuncay.mobsec.maswe0028.secure

import com.hasantuncay.mobsec.maswe0028.common.Maswe0028Vector
import com.hasantuncay.mobsec.maswe0028.common.Maswe0028Mitigation
import com.hasantuncay.mobsec.maswe0028.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0028NetworkSecureScreen(onBack: () -> Unit) {
    BaseSecureScreen(
        meta = Maswe0028Mitigation.meta,
        vectors = Maswe0028Mitigation.entries,
        onBack = onBack
    )
}
