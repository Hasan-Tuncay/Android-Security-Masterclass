package com.hasantuncay.mobsec.platform.maswe0035

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0035Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0035PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0035Vector.entries,
        onBack = onBack
    )
}
