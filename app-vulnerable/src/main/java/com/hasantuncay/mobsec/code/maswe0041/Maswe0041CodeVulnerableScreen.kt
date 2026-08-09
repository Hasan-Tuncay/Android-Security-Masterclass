package com.hasantuncay.mobsec.code.maswe0041

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0041Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0041CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0041Vector.meta,
        vectors = Maswe0041Vector.entries,
        onBack = onBack
    )
}
