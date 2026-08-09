package com.hasantuncay.mobsec.maswe0033.vulnerable

import com.hasantuncay.mobsec.maswe0033.common.Maswe0033Vector
import com.hasantuncay.mobsec.maswe0033.common.Maswe0033Mitigation
import com.hasantuncay.mobsec.maswe0033.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0033PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0033Vector.meta,
        vectors = Maswe0033Vector.entries,
        onBack = onBack
    )
}
