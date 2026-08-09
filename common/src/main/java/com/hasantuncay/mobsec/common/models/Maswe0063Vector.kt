package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0063Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISCONFIGURED_BUILD_SETTINGS(
        titleVulnRes = R.string.maswe_0063_vector_misconfigured_build_settings_vuln,
        msgVulnRes = R.string.maswe_0063_msg_misconfigured_build_settings_vuln,
        icon = Icons.Default.BuildCircle
    ),
    WEBVIEW_DEBUGGING_ENABLED(
        titleVulnRes = R.string.maswe_0063_vector_webview_debugging_enabled_vuln,
        msgVulnRes = R.string.maswe_0063_msg_webview_debugging_enabled_vuln,
        icon = Icons.Default.Javascript
    );

    override val masweId = "MASWE-0063"
    override val screenTitleVulnRes = R.string.maswe_0063_vuln_title
    override val screenDescVulnRes = R.string.maswe_0063_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0063_vuln_vectors_title
}
