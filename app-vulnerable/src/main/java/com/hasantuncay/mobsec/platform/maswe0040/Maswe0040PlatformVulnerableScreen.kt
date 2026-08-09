package com.hasantuncay.mobsec.platform.maswe0040

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0040Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0040PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0040Vector.meta,
        vectors = Maswe0040Vector.entries,
        onBack = onBack
    )
}
