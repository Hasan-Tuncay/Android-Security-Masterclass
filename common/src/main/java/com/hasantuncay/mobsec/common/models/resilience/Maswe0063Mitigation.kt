package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0063Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISCONFIGURED_BUILD_SETTINGS(
        titleRes = R.string.maswe_0063_vector_misconfigured_build_settings_secure,
        msgRes = R.string.maswe_0063_msg_misconfigured_build_settings_secure,
        icon = Icons.Default.BuildCircle
    ),
    WEBVIEW_DEBUGGING_ENABLED(
        titleRes = R.string.maswe_0063_vector_webview_debugging_enabled_secure,
        msgRes = R.string.maswe_0063_msg_webview_debugging_enabled_secure,
        icon = Icons.Default.Javascript
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0063",
            titleRes = R.string.maswe_0063_secure_title,
            descRes = R.string.maswe_0063_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0063_secure_vectors_title
        )
    }
}
