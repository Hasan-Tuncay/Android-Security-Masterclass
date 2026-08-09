package com.hasantuncay.mobsec.maswe0044.vulnerable

import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Vector
import com.hasantuncay.mobsec.maswe0044.common.Maswe0044Mitigation
import com.hasantuncay.mobsec.maswe0044.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0044CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0044Vector.meta,
        vectors = Maswe0044Vector.entries,
        onBack = onBack
    )
}
