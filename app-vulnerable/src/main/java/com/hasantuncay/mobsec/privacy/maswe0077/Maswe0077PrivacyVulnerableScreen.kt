package com.hasantuncay.mobsec.privacy.maswe0077

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0077Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0077PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0077Vector.meta,
        vectors = Maswe0077Vector.entries,
        onBack = onBack
    )
}
