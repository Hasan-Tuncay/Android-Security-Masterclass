package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * Backward-compatible wrapper that delegates to [BaseMasweScreen] with [ScreenMode.SECURE].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : MasweMitigation> BaseSecureScreen(
    meta: MasweScreenMeta,
    vectors: List<T>,
    onBack: () -> Unit,
    onVectorClicked: (suspend (T) -> String?)? = null,
    content: @Composable (ColumnScope.() -> Unit)? = null
) {
    BaseMasweScreen(
        mode = ScreenMode.SECURE,
        meta = meta,
        items = vectors,
        onBack = onBack,
        onItemClicked = onVectorClicked,
        content = content
    )
}
