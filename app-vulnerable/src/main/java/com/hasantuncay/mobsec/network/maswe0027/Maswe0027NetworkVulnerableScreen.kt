package com.hasantuncay.mobsec.network.maswe0027

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.network.Maswe0027Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0027NetworkVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0027Vector.meta,
        vectors = Maswe0027Vector.entries,
        onBack = onBack
    )
}
