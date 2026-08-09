package com.hasantuncay.mobsec.storage.maswe0006

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.storage.Maswe0006Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0006StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0006Vector.meta,
        vectors = Maswe0006Vector.entries,
        onBack = onBack
    )
}
