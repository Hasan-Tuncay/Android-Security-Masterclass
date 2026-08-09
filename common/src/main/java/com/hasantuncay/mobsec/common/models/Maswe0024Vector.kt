package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0024Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SESSIONS_NOT_INVALIDATED_SERVER(
        titleVulnRes = R.string.maswe_0024_vector_sessions_not_invalidated_server_vuln,
        msgVulnRes = R.string.maswe_0024_msg_sessions_not_invalidated_server_vuln,
        icon = Icons.Default.Warning
    ),
    MISSING_CLIENT_SESSION_TERMINATION(
        titleVulnRes = R.string.maswe_0024_vector_missing_client_session_termination_vuln,
        msgVulnRes = R.string.maswe_0024_msg_missing_client_session_termination_vuln,
        icon = Icons.Default.ExitToApp
    ),
    NO_REAUTH_ON_STATE_CHANGES(
        titleVulnRes = R.string.maswe_0024_vector_no_reauth_on_state_changes_vuln,
        msgVulnRes = R.string.maswe_0024_msg_no_reauth_on_state_changes_vuln,
        icon = Icons.Default.Refresh
    ),
    CACHED_DATA_NOT_CLEARED(
        titleVulnRes = R.string.maswe_0024_vector_cached_data_not_cleared_vuln,
        msgVulnRes = R.string.maswe_0024_msg_cached_data_not_cleared_vuln,
        icon = Icons.Default.DataArray
    ),
    MISSING_INACTIVITY_TIMEOUT(
        titleVulnRes = R.string.maswe_0024_vector_missing_inactivity_timeout_vuln,
        msgVulnRes = R.string.maswe_0024_msg_missing_inactivity_timeout_vuln,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0024"
    override val screenTitleVulnRes = R.string.maswe_0024_vuln_title
    override val screenDescVulnRes = R.string.maswe_0024_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0024_vuln_vectors_title
}
