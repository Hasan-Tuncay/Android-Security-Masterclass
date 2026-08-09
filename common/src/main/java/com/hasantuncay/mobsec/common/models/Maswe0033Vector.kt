package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0033Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    BRIDGES_REACHABLE_BY_UNTRUSTED(
        titleVulnRes = R.string.maswe_0033_vector_bridges_reachable_by_untrusted_vuln,
        msgVulnRes = R.string.maswe_0033_msg_bridges_reachable_by_untrusted_vuln,
        icon = Icons.Default.Public
    ),
    UNVALIDATED_BRIDGE_MESSAGES(
        titleVulnRes = R.string.maswe_0033_vector_unvalidated_bridge_messages_vuln,
        msgVulnRes = R.string.maswe_0033_msg_unvalidated_bridge_messages_vuln,
        icon = Icons.Default.Message
    ),
    GLOBALLY_EXPOSED_BRIDGES(
        titleVulnRes = R.string.maswe_0033_vector_globally_exposed_bridges_vuln,
        msgVulnRes = R.string.maswe_0033_msg_globally_exposed_bridges_vuln,
        icon = Icons.Default.Language
    ),
    APP_OWNED_SCRIPTS_PAGE_WORLD(
        titleVulnRes = R.string.maswe_0033_vector_app_owned_scripts_page_world_vuln,
        msgVulnRes = R.string.maswe_0033_msg_app_owned_scripts_page_world_vuln,
        icon = Icons.Default.Javascript
    ),
    SENSITIVE_DATA_IN_BRIDGE_REPLIES(
        titleVulnRes = R.string.maswe_0033_vector_sensitive_data_in_bridge_replies_vuln,
        msgVulnRes = R.string.maswe_0033_msg_sensitive_data_in_bridge_replies_vuln,
        icon = Icons.Default.Security
    ),
    OVER_EXPOSED_BRIDGES(
        titleVulnRes = R.string.maswe_0033_vector_over_exposed_bridges_vuln,
        msgVulnRes = R.string.maswe_0033_msg_over_exposed_bridges_vuln,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0033"
    override val screenTitleVulnRes = R.string.maswe_0033_vuln_title
    override val screenDescVulnRes = R.string.maswe_0033_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0033_vuln_vectors_title
}
