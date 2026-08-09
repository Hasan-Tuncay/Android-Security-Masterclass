package com.hasantuncay.mobsec.auth.maswe0020

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0020Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0020AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0020Vector.entries,
        onBack = onBack
    )
}
