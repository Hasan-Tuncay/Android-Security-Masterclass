package com.hasantuncay.mobsec.platform.maswe0036

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0036Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0036PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0036Vector.entries,
        onBack = onBack
    )
}
