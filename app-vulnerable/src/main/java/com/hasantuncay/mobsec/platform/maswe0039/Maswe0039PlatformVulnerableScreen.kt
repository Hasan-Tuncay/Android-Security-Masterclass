package com.hasantuncay.mobsec.platform.maswe0039

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0039Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0039PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0039Vector.entries,
        onBack = onBack
    )
}
