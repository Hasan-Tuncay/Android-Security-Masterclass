package com.hasantuncay.mobsec.platform.maswe0030

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0030Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0030PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0030Vector.entries,
        onBack = onBack
    )
}
