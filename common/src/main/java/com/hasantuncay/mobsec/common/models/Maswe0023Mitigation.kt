package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0023Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_REAUTH_FOR_SENSITIVE(
        titleSecureRes = R.string.maswe_0023_vector_no_reauth_for_sensitive_secure,
        msgSecureRes = R.string.maswe_0023_msg_no_reauth_for_sensitive_secure,
        icon = Icons.Default.Warning
    ),
    STEP_UP_NOT_BOUND_TO_ACTION(
        titleSecureRes = R.string.maswe_0023_vector_step_up_not_bound_to_action_secure,
        msgSecureRes = R.string.maswe_0023_msg_step_up_not_bound_to_action_secure,
        icon = Icons.Default.Lock
    ),
    STEP_UP_NOT_SERVER_SIDE(
        titleSecureRes = R.string.maswe_0023_vector_step_up_not_server_side_secure,
        msgSecureRes = R.string.maswe_0023_msg_step_up_not_server_side_secure,
        icon = Icons.Default.NoEncryption
    ),
    UNIFORM_ASSURANCE_LEVEL(
        titleSecureRes = R.string.maswe_0023_vector_uniform_assurance_level_secure,
        msgSecureRes = R.string.maswe_0023_msg_uniform_assurance_level_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0023"
    override val screenTitleSecureRes = R.string.maswe_0023_secure_title
    override val screenDescSecureRes = R.string.maswe_0023_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0023_secure_vectors_title
}
