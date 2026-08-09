package com.hasantuncay.mobsec.privacy.maswe0070

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0070Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0070PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0070Vector.entries,
        onBack = onBack
    )
}
