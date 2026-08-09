package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0022Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INVALIDATION_DISABLED(
        titleVulnRes = R.string.maswe_0022_vector_invalidation_disabled_vuln,
        msgVulnRes = R.string.maswe_0022_msg_invalidation_disabled_vuln,
        icon = Icons.Default.Warning
    ),
    INVALIDATION_NOT_ENABLED(
        titleVulnRes = R.string.maswe_0022_vector_invalidation_not_enabled_vuln,
        msgVulnRes = R.string.maswe_0022_msg_invalidation_not_enabled_vuln,
        icon = Icons.Default.Key
    ),
    UNSAFE_INVALIDATION_RECOVERY(
        titleVulnRes = R.string.maswe_0022_vector_unsafe_invalidation_recovery_vuln,
        msgVulnRes = R.string.maswe_0022_msg_unsafe_invalidation_recovery_vuln,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0022"
    override val screenTitleVulnRes = R.string.maswe_0022_vuln_title
    override val screenDescVulnRes = R.string.maswe_0022_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0022_vuln_vectors_title
}
