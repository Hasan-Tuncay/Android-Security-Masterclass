package com.hasantuncay.mobsec.maswe0004.vulnerable

import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation
import com.hasantuncay.mobsec.maswe0004.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0004StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0004Vector.meta,
        vectors = Maswe0004Vector.entries,
        onBack = onBack
    )
}
