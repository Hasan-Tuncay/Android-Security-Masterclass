package com.hasantuncay.mobsec.auth.maswe0022

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0022Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0022AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0022Vector.entries,
        onBack = onBack
    )
}
