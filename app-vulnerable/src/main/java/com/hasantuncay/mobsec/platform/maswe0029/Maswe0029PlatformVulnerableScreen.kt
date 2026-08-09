package com.hasantuncay.mobsec.platform.maswe0029

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0029Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0029PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0029Vector.entries,
        onBack = onBack
    )
}
