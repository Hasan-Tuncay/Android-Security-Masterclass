package com.hasantuncay.mobsec.privacy.maswe0076

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0076Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0076PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0076Vector.meta,
        vectors = Maswe0076Vector.entries,
        onBack = onBack
    )
}
