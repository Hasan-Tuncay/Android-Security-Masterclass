package com.hasantuncay.mobsec.auth.maswe0021

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0021Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0021AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0021Vector.entries,
        onBack = onBack
    )
}
