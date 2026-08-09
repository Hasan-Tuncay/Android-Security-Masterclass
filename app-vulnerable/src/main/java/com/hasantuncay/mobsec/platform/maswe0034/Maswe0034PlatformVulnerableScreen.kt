package com.hasantuncay.mobsec.platform.maswe0034

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0034Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0034PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0034Vector.meta,
        vectors = Maswe0034Vector.entries,
        onBack = onBack
    )
}
