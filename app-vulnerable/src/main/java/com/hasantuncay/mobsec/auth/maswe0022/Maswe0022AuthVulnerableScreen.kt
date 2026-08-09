package com.hasantuncay.mobsec.auth.maswe0022

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0022Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0022AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0022Vector.meta,
        vectors = Maswe0022Vector.entries,
        onBack = onBack
    )
}
