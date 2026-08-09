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
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0024Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SESSIONS_NOT_INVALIDATED_SERVER(
        titleRes = R.string.maswe_0024_vector_sessions_not_invalidated_server_vuln,
        msgRes = R.string.maswe_0024_msg_sessions_not_invalidated_server_vuln,
        icon = Icons.Default.Warning
    ),
    MISSING_CLIENT_SESSION_TERMINATION(
        titleRes = R.string.maswe_0024_vector_missing_client_session_termination_vuln,
        msgRes = R.string.maswe_0024_msg_missing_client_session_termination_vuln,
        icon = Icons.AutoMirrored.Filled.ExitToApp
    ),
    NO_REAUTH_ON_STATE_CHANGES(
        titleRes = R.string.maswe_0024_vector_no_reauth_on_state_changes_vuln,
        msgRes = R.string.maswe_0024_msg_no_reauth_on_state_changes_vuln,
        icon = Icons.Default.Refresh
    ),
    CACHED_DATA_NOT_CLEARED(
        titleRes = R.string.maswe_0024_vector_cached_data_not_cleared_vuln,
        msgRes = R.string.maswe_0024_msg_cached_data_not_cleared_vuln,
        icon = Icons.Default.DataArray
    ),
    MISSING_INACTIVITY_TIMEOUT(
        titleRes = R.string.maswe_0024_vector_missing_inactivity_timeout_vuln,
        msgRes = R.string.maswe_0024_msg_missing_inactivity_timeout_vuln,
        icon = Icons.Default.Lock
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0024",
            titleRes = CommonR.string.maswe_0024_vuln_title,
            descRes = CommonR.string.maswe_0024_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0024_vuln_vectors_title
        )
    }
}
