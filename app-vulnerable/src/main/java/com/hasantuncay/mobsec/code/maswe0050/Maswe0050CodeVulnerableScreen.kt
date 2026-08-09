package com.hasantuncay.mobsec.code.maswe0050

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0050Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0050CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0050Vector.entries,
        onBack = onBack
    )
}
