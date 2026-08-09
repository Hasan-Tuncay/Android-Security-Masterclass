package com.hasantuncay.mobsec.code.maswe0042

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0042Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0042CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0042Vector.meta,
        vectors = Maswe0042Vector.entries,
        onBack = onBack
    )
}
