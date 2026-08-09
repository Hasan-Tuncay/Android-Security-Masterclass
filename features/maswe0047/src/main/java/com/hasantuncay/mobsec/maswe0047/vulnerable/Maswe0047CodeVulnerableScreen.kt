package com.hasantuncay.mobsec.maswe0047.vulnerable

import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Vector
import com.hasantuncay.mobsec.maswe0047.common.Maswe0047Mitigation
import com.hasantuncay.mobsec.maswe0047.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0047CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0047Vector.meta,
        vectors = Maswe0047Vector.entries,
        onBack = onBack
    )
}
