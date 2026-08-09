package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0024Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SESSIONS_NOT_INVALIDATED_SERVER(
        titleSecureRes = R.string.maswe_0024_vector_sessions_not_invalidated_server_secure,
        msgSecureRes = R.string.maswe_0024_msg_sessions_not_invalidated_server_secure,
        icon = Icons.Default.Warning
    ),
    MISSING_CLIENT_SESSION_TERMINATION(
        titleSecureRes = R.string.maswe_0024_vector_missing_client_session_termination_secure,
        msgSecureRes = R.string.maswe_0024_msg_missing_client_session_termination_secure,
        icon = Icons.Default.ExitToApp
    ),
    NO_REAUTH_ON_STATE_CHANGES(
        titleSecureRes = R.string.maswe_0024_vector_no_reauth_on_state_changes_secure,
        msgSecureRes = R.string.maswe_0024_msg_no_reauth_on_state_changes_secure,
        icon = Icons.Default.Refresh
    ),
    CACHED_DATA_NOT_CLEARED(
        titleSecureRes = R.string.maswe_0024_vector_cached_data_not_cleared_secure,
        msgSecureRes = R.string.maswe_0024_msg_cached_data_not_cleared_secure,
        icon = Icons.Default.DataArray
    ),
    MISSING_INACTIVITY_TIMEOUT(
        titleSecureRes = R.string.maswe_0024_vector_missing_inactivity_timeout_secure,
        msgSecureRes = R.string.maswe_0024_msg_missing_inactivity_timeout_secure,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0024"
    override val screenTitleSecureRes = R.string.maswe_0024_secure_title
    override val screenDescSecureRes = R.string.maswe_0024_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0024_secure_vectors_title
}
