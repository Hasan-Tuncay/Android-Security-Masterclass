package com.hasantuncay.mobsec.storage.maswe0003

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.storage.Maswe0003Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@Composable
fun Maswe0003StorageVulnerableScreen(onBack: () -> Unit) {
    BaseVulnerableScreen(
        meta = Maswe0003Vector.meta,
        vectors = Maswe0003Vector.entries,
        onBack = onBack
    )
}
