package com.hasantuncay.mobsec.network.maswe0026

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0026Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0026NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0026Vector.meta,
        vectors = Maswe0026Vector.entries,
        onBack = onBack
    )
}
