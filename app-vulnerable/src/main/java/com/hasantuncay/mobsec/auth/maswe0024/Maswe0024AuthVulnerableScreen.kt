package com.hasantuncay.mobsec.auth.maswe0024

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0024Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0024AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0024Vector.meta,
        vectors = Maswe0024Vector.entries,
        onBack = onBack
    )
}
