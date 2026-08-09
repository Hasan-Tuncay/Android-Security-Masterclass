package com.hasantuncay.mobsec.auth.maswe0023

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0023Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0023AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0023Vector.entries,
        onBack = onBack
    )
}
