package com.hasantuncay.mobsec.privacy.maswe0075

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0075Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0075PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0075Vector.entries,
        onBack = onBack
    )
}
