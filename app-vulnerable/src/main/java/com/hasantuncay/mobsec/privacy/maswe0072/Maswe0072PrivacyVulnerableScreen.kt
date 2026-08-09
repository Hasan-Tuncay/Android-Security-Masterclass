package com.hasantuncay.mobsec.privacy.maswe0072

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0072Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0072PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0072Vector.meta,
        vectors = Maswe0072Vector.entries,
        onBack = onBack
    )
}
