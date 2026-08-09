package com.hasantuncay.mobsec.privacy.maswe0067

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.privacy.Maswe0067Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0067PrivacyVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0067Vector.meta,
        vectors = Maswe0067Vector.entries,
        onBack = onBack
    )
}
