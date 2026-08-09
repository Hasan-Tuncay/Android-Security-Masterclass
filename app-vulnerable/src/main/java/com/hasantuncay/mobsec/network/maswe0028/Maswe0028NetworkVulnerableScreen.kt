package com.hasantuncay.mobsec.network.maswe0028

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0028Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0028NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0028Vector.meta,
        vectors = Maswe0028Vector.entries,
        onBack = onBack
    )
}
