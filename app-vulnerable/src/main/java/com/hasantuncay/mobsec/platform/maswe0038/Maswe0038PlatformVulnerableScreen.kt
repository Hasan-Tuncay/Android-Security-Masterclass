package com.hasantuncay.mobsec.platform.maswe0038

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0038Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0038PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0038Vector.entries,
        onBack = onBack
    )
}
