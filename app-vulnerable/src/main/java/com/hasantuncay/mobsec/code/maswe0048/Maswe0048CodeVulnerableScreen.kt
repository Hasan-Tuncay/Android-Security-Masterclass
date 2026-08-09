package com.hasantuncay.mobsec.code.maswe0048

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0048Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0048CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0048Vector.meta,
        vectors = Maswe0048Vector.entries,
        onBack = onBack
    )
}
