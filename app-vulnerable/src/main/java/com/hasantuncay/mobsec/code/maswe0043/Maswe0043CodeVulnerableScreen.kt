package com.hasantuncay.mobsec.code.maswe0043

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0043Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0043CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0043Vector.entries,
        onBack = onBack
    )
}
