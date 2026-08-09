package com.hasantuncay.mobsec.privacy.maswe0070

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0070Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0070PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0070Vector.meta,
        vectors = Maswe0070Vector.entries,
        onBack = onBack
    )
}
