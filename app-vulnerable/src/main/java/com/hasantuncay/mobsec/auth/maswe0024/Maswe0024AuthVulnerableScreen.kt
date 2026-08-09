package com.hasantuncay.mobsec.auth.maswe0024

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0024Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0024AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0024Vector.entries,
        onBack = onBack
    )
}
