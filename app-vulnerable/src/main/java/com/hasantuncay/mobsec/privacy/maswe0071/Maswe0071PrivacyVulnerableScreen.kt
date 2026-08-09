package com.hasantuncay.mobsec.privacy.maswe0071

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0071Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0071PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0071Vector.meta,
        vectors = Maswe0071Vector.entries,
        onBack = onBack
    )
}
