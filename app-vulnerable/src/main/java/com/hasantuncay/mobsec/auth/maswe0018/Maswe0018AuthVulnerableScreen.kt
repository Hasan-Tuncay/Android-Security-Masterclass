package com.hasantuncay.mobsec.auth.maswe0018

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0018Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0018AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0018Vector.meta,
        vectors = Maswe0018Vector.entries,
        onBack = onBack
    )
}
