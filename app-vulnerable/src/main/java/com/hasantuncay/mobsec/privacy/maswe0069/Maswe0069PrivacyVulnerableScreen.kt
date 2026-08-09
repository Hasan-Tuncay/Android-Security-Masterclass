package com.hasantuncay.mobsec.privacy.maswe0069

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0069Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0069PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0069Vector.meta,
        vectors = Maswe0069Vector.entries,
        onBack = onBack
    )
}
