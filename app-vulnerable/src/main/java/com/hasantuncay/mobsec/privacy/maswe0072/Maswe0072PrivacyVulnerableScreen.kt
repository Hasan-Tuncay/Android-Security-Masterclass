package com.hasantuncay.mobsec.privacy.maswe0072

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0072Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0072PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0072Vector.entries,
        onBack = onBack
    )
}
