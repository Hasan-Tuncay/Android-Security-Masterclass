package com.hasantuncay.mobsec.storage.maswe0004

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0004Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0004StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0004Vector.entries,
        onBack = onBack
    )
}
