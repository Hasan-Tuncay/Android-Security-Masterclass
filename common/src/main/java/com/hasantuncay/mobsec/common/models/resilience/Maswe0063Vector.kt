package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0063Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISCONFIGURED_BUILD_SETTINGS(
        titleRes = R.string.maswe_0063_vector_misconfigured_build_settings_vuln,
        msgRes = R.string.maswe_0063_msg_misconfigured_build_settings_vuln,
        icon = Icons.Default.BuildCircle
    ),
    WEBVIEW_DEBUGGING_ENABLED(
        titleRes = R.string.maswe_0063_vector_webview_debugging_enabled_vuln,
        msgRes = R.string.maswe_0063_msg_webview_debugging_enabled_vuln,
        icon = Icons.Default.Javascript
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0063",
            titleRes = R.string.maswe_0063_vuln_title,
            descRes = R.string.maswe_0063_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0063_vuln_vectors_title
        )
    }
}
