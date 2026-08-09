package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0052Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_VIRTUALIZATION_CHECKS(
        titleVulnRes = R.string.maswe_0052_vector_no_virtualization_checks_vuln,
        msgVulnRes = R.string.maswe_0052_msg_no_virtualization_checks_vuln,
        icon = Icons.Default.LaptopWindows
    ),
    KNOWN_FRAMEWORKS_NOT_DETECTED(
        titleVulnRes = R.string.maswe_0052_vector_known_frameworks_not_detected_vuln,
        msgVulnRes = R.string.maswe_0052_msg_known_frameworks_not_detected_vuln,
        icon = Icons.Default.Warning
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0052_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0052_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0052"
    override val screenTitleVulnRes = R.string.maswe_0052_vuln_title
    override val screenDescVulnRes = R.string.maswe_0052_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0052_vuln_vectors_title
}
