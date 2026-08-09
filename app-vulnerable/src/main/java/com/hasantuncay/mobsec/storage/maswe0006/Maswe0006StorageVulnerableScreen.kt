package com.hasantuncay.mobsec.storage.maswe0006

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.Maswe0006Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0006StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        vectors = Maswe0006Vector.entries,
        onBack = onBack
    )
}
