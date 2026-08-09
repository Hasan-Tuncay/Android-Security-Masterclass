package com.hasantuncay.mobsec.auth.maswe0025

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0025Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0025AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0025Vector.entries,
        onBack = onBack
    )
}
