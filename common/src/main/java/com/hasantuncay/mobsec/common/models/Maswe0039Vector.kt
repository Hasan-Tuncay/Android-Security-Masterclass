package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0039Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    TOUCH_FILTERING_NOT_ENABLED(
        titleVulnRes = R.string.maswe_0039_vector_touch_filtering_not_enabled_vuln,
        msgVulnRes = R.string.maswe_0039_msg_touch_filtering_not_enabled_vuln,
        icon = Icons.Default.TouchApp
    ),
    EXTERNAL_OVERLAYS_NOT_HIDDEN(
        titleVulnRes = R.string.maswe_0039_vector_external_overlays_not_hidden_vuln,
        msgVulnRes = R.string.maswe_0039_msg_external_overlays_not_hidden_vuln,
        icon = Icons.Default.Layers
    ),
    SENSITIVE_SCREENS_NOT_PROTECTED(
        titleVulnRes = R.string.maswe_0039_vector_sensitive_screens_not_protected_vuln,
        msgVulnRes = R.string.maswe_0039_msg_sensitive_screens_not_protected_vuln,
        icon = Icons.Default.Security
    );

    override val masweId = "MASWE-0039"
    override val screenTitleVulnRes = R.string.maswe_0039_vuln_title
    override val screenDescVulnRes = R.string.maswe_0039_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0039_vuln_vectors_title
}
