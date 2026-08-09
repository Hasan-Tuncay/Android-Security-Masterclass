package com.hasantuncay.mobsec.privacy.maswe0074

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0074Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0074PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0074Vector.meta,
        vectors = Maswe0074Vector.entries,
        onBack = onBack
    )
}
