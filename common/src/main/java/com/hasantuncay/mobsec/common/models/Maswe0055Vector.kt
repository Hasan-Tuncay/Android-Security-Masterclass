package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0055Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_HOSTILE_ENVIRONMENT_CHECKS(
        titleVulnRes = R.string.maswe_0055_vector_no_hostile_environment_checks_vuln,
        msgVulnRes = R.string.maswe_0055_msg_no_hostile_environment_checks_vuln,
        icon = Icons.Default.PestControl
    ),
    ABUSE_PRONE_CAPABILITIES_IGNORED(
        titleVulnRes = R.string.maswe_0055_vector_abuse_prone_capabilities_ignored_vuln,
        msgVulnRes = R.string.maswe_0055_msg_abuse_prone_capabilities_ignored_vuln,
        icon = Icons.Default.Rule
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0055_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0055_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0055_vector_insufficient_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0055_msg_insufficient_response_strategy_vuln,
        icon = Icons.Default.PhoneIphone
    );

    override val masweId = "MASWE-0055"
    override val screenTitleVulnRes = R.string.maswe_0055_vuln_title
    override val screenDescVulnRes = R.string.maswe_0055_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0055_vuln_vectors_title
}
