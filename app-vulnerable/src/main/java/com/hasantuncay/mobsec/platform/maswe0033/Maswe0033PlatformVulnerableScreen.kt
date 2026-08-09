package com.hasantuncay.mobsec.platform.maswe0033

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.platform.Maswe0033Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0033PlatformVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0033Vector.meta,
        vectors = Maswe0033Vector.entries,
        onBack = onBack
    )
}
