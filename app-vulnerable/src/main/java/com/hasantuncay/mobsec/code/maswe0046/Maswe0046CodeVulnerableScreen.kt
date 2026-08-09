package com.hasantuncay.mobsec.code.maswe0046

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0046Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0046CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0046Vector.meta,
        vectors = Maswe0046Vector.entries,
        onBack = onBack
    )
}
