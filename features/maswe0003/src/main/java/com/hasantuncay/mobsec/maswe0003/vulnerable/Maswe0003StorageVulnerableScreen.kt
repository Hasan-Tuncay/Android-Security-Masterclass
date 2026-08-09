package com.hasantuncay.mobsec.maswe0003.vulnerable

import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import com.hasantuncay.mobsec.maswe0003.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0003StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0003Vector.meta,
        vectors = Maswe0003Vector.entries,
        onBack = onBack
    )
}
