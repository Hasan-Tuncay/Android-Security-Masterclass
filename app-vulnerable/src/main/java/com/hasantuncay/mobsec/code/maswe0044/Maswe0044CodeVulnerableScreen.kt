package com.hasantuncay.mobsec.code.maswe0044

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0044Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0044CodeVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0044Vector.entries,
        onBack = onBack
    )
}
