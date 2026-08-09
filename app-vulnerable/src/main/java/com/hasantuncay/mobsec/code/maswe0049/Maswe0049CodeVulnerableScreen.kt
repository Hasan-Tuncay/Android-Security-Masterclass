package com.hasantuncay.mobsec.code.maswe0049

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.code.Maswe0049Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0049CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0049Vector.meta,
        vectors = Maswe0049Vector.entries,
        onBack = onBack
    )
}
