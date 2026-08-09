package com.hasantuncay.mobsec.code.maswe0047

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0047Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0047CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0047Vector.meta,
        vectors = Maswe0047Vector.entries,
        onBack = onBack
    )
}
