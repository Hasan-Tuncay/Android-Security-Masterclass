package com.hasantuncay.mobsec.code.maswe0041

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0041Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0041CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0041Vector.entries,
        onBack = onBack
    )
}
