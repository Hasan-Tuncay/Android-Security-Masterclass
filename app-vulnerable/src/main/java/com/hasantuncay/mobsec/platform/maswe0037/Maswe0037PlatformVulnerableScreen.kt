package com.hasantuncay.mobsec.platform.maswe0037

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0037Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0037PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0037Vector.meta,
        vectors = Maswe0037Vector.entries,
        onBack = onBack
    )
}
