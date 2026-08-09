package com.hasantuncay.mobsec.privacy.maswe0077

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0077Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0077PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0077Vector.entries,
        onBack = onBack
    )
}
