package com.hasantuncay.mobsec.code.maswe0045

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0045Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0045CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0045Vector.meta,
        vectors = Maswe0045Vector.entries,
        onBack = onBack
    )
}
