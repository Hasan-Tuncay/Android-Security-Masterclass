package com.hasantuncay.mobsec.privacy.maswe0078

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0078Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0078PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0078Vector.meta,
        vectors = Maswe0078Vector.entries,
        onBack = onBack
    )
}
