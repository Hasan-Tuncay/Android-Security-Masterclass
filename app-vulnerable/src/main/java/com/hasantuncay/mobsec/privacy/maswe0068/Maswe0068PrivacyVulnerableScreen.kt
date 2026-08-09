package com.hasantuncay.mobsec.privacy.maswe0068

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0068Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0068PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0068Vector.meta,
        vectors = Maswe0068Vector.entries,
        onBack = onBack
    )
}
