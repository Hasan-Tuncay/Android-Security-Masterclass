package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0042Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    OUTDATED_TARGET_VERSION(
        titleVulnRes = R.string.maswe_0042_vector_outdated_target_version_vuln,
        msgVulnRes = R.string.maswe_0042_msg_outdated_target_version_vuln,
        icon = Icons.Default.SystemUpdate
    ),
    COMPATIBILITY_BEHAVIORS_LEFT(
        titleVulnRes = R.string.maswe_0042_vector_compatibility_behaviors_left_vuln,
        msgVulnRes = R.string.maswe_0042_msg_compatibility_behaviors_left_vuln,
        icon = Icons.Default.Build
    );

    override val masweId = "MASWE-0042"
    override val screenTitleVulnRes = R.string.maswe_0042_vuln_title
    override val screenDescVulnRes = R.string.maswe_0042_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0042_vuln_vectors_title
}
