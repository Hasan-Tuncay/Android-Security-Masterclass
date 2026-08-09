package com.hasantuncay.mobsec.privacy.maswe0076

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0076Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0076PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0076Vector.entries,
        onBack = onBack
    )
}
