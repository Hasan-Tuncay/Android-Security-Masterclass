package com.hasantuncay.mobsec.maswe0028.vulnerable

import com.hasantuncay.mobsec.maswe0028.common.Maswe0028Vector
import com.hasantuncay.mobsec.maswe0028.common.Maswe0028Mitigation
import com.hasantuncay.mobsec.maswe0028.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0028NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0028Vector.meta,
        vectors = Maswe0028Vector.entries,
        onBack = onBack
    )
}
