package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0023Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_REAUTH_FOR_SENSITIVE(
        titleVulnRes = R.string.maswe_0023_vector_no_reauth_for_sensitive_vuln,
        msgVulnRes = R.string.maswe_0023_msg_no_reauth_for_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    STEP_UP_NOT_BOUND_TO_ACTION(
        titleVulnRes = R.string.maswe_0023_vector_step_up_not_bound_to_action_vuln,
        msgVulnRes = R.string.maswe_0023_msg_step_up_not_bound_to_action_vuln,
        icon = Icons.Default.Lock
    ),
    STEP_UP_NOT_SERVER_SIDE(
        titleVulnRes = R.string.maswe_0023_vector_step_up_not_server_side_vuln,
        msgVulnRes = R.string.maswe_0023_msg_step_up_not_server_side_vuln,
        icon = Icons.Default.NoEncryption
    ),
    UNIFORM_ASSURANCE_LEVEL(
        titleVulnRes = R.string.maswe_0023_vector_uniform_assurance_level_vuln,
        msgVulnRes = R.string.maswe_0023_msg_uniform_assurance_level_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0023"
    override val screenTitleVulnRes = R.string.maswe_0023_vuln_title
    override val screenDescVulnRes = R.string.maswe_0023_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0023_vuln_vectors_title
}
