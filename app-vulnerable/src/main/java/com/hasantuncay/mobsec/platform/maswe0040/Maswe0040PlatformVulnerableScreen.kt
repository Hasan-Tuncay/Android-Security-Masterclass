package com.hasantuncay.mobsec.platform.maswe0040

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0040Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0040PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0040Vector.entries,
        onBack = onBack
    )
}
