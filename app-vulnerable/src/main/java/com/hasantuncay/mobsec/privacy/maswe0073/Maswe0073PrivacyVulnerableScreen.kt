package com.hasantuncay.mobsec.privacy.maswe0073

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0073Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0073PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0073Vector.meta,
        vectors = Maswe0073Vector.entries,
        onBack = onBack
    )
}
