package com.hasantuncay.mobsec.maswe0045.vulnerable

import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Vector
import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Mitigation
import com.hasantuncay.mobsec.maswe0045.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0045CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0045Vector.meta,
        vectors = Maswe0045Vector.entries,
        onBack = onBack
    )
}
