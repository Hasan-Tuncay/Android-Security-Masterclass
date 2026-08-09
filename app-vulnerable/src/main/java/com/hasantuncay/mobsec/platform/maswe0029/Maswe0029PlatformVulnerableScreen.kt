package com.hasantuncay.mobsec.platform.maswe0029

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0029Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0029PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0029Vector.meta,
        vectors = Maswe0029Vector.entries,
        onBack = onBack
    )
}
