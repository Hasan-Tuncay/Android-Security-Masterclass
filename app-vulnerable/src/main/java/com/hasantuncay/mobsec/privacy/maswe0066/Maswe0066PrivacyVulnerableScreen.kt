package com.hasantuncay.mobsec.privacy.maswe0066

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0066Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0066PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0066Vector.entries,
        onBack = onBack
    )
}
