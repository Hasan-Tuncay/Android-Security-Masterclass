package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0023Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_REAUTH_FOR_SENSITIVE(
        titleRes = R.string.maswe_0023_vector_no_reauth_for_sensitive_vuln,
        msgRes = R.string.maswe_0023_msg_no_reauth_for_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    STEP_UP_NOT_BOUND_TO_ACTION(
        titleRes = R.string.maswe_0023_vector_step_up_not_bound_to_action_vuln,
        msgRes = R.string.maswe_0023_msg_step_up_not_bound_to_action_vuln,
        icon = Icons.Default.Lock
    ),
    STEP_UP_NOT_SERVER_SIDE(
        titleRes = R.string.maswe_0023_vector_step_up_not_server_side_vuln,
        msgRes = R.string.maswe_0023_msg_step_up_not_server_side_vuln,
        icon = Icons.Default.NoEncryption
    ),
    UNIFORM_ASSURANCE_LEVEL(
        titleRes = R.string.maswe_0023_vector_uniform_assurance_level_vuln,
        msgRes = R.string.maswe_0023_msg_uniform_assurance_level_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0023",
            titleRes = R.string.maswe_0023_vuln_title,
            descRes = R.string.maswe_0023_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0023_vuln_vectors_title
        )
    }
}
