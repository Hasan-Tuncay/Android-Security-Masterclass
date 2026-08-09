package com.hasantuncay.mobsec.auth.maswe0018

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0018Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0018AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0018Vector.entries,
        onBack = onBack
    )
}
