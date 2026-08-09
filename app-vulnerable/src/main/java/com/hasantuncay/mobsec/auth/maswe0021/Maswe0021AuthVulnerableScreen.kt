package com.hasantuncay.mobsec.auth.maswe0021

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.auth.Maswe0021Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0021AuthVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0021Vector.meta,
        vectors = Maswe0021Vector.entries,
        onBack = onBack
    )
}
