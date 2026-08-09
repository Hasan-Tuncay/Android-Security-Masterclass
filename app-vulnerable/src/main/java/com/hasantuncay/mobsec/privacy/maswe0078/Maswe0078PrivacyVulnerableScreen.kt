package com.hasantuncay.mobsec.privacy.maswe0078

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0078Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0078PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0078Vector.entries,
        onBack = onBack
    )
}
