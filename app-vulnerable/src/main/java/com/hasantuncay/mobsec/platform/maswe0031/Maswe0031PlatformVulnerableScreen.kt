package com.hasantuncay.mobsec.platform.maswe0031

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0031Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0031PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0031Vector.entries,
        onBack = onBack
    )
}
