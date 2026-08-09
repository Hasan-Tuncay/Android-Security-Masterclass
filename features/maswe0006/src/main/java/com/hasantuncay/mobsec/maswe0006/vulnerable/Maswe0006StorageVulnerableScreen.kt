package com.hasantuncay.mobsec.maswe0006.vulnerable

import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Vector
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation
import com.hasantuncay.mobsec.maswe0006.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0006StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0006Vector.meta,
        vectors = Maswe0006Vector.entries,
        onBack = onBack
    )
}
