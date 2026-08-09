package com.hasantuncay.mobsec.maswe0049.vulnerable

import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Vector
import com.hasantuncay.mobsec.maswe0049.common.Maswe0049Mitigation
import com.hasantuncay.mobsec.maswe0049.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0049CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0049Vector.meta,
        vectors = Maswe0049Vector.entries,
        onBack = onBack
    )
}
