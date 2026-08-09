package com.hasantuncay.mobsec.auth.maswe0019

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0019Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0019AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0019Vector.entries,
        onBack = onBack
    )
}
