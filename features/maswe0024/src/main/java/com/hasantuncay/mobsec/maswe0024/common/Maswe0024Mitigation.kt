package com.hasantuncay.mobsec.maswe0024.common

import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Vector
import com.hasantuncay.mobsec.maswe0024.common.Maswe0024Mitigation
import com.hasantuncay.mobsec.maswe0024.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0024Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SESSIONS_NOT_INVALIDATED_SERVER(
        titleRes = R.string.maswe_0024_vector_sessions_not_invalidated_server_secure,
        msgRes = R.string.maswe_0024_msg_sessions_not_invalidated_server_secure,
        icon = Icons.Default.Warning
    ),
    MISSING_CLIENT_SESSION_TERMINATION(
        titleRes = R.string.maswe_0024_vector_missing_client_session_termination_secure,
        msgRes = R.string.maswe_0024_msg_missing_client_session_termination_secure,
        icon = Icons.AutoMirrored.Filled.ExitToApp
    ),
    NO_REAUTH_ON_STATE_CHANGES(
        titleRes = R.string.maswe_0024_vector_no_reauth_on_state_changes_secure,
        msgRes = R.string.maswe_0024_msg_no_reauth_on_state_changes_secure,
        icon = Icons.Default.Refresh
    ),
    CACHED_DATA_NOT_CLEARED(
        titleRes = R.string.maswe_0024_vector_cached_data_not_cleared_secure,
        msgRes = R.string.maswe_0024_msg_cached_data_not_cleared_secure,
        icon = Icons.Default.DataArray
    ),
    MISSING_INACTIVITY_TIMEOUT(
        titleRes = R.string.maswe_0024_vector_missing_inactivity_timeout_secure,
        msgRes = R.string.maswe_0024_msg_missing_inactivity_timeout_secure,
        icon = Icons.Default.Lock
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0024",
            titleRes = CommonR.string.maswe_0024_secure_title,
            descRes = CommonR.string.maswe_0024_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0024_secure_vectors_title
        )
    }
}
