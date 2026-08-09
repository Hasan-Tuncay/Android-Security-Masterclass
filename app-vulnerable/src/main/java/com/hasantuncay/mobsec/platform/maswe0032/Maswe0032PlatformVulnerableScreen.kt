package com.hasantuncay.mobsec.platform.maswe0032

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0032Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0032PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0032Vector.meta,
        vectors = Maswe0032Vector.entries,
        onBack = onBack
    )
}
