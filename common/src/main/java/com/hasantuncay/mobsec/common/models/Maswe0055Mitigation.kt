package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0055Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_HOSTILE_ENVIRONMENT_CHECKS(
        titleSecureRes = R.string.maswe_0055_vector_no_hostile_environment_checks_secure,
        msgSecureRes = R.string.maswe_0055_msg_no_hostile_environment_checks_secure,
        icon = Icons.Default.PestControl
    ),
    ABUSE_PRONE_CAPABILITIES_IGNORED(
        titleSecureRes = R.string.maswe_0055_vector_abuse_prone_capabilities_ignored_secure,
        msgSecureRes = R.string.maswe_0055_msg_abuse_prone_capabilities_ignored_secure,
        icon = Icons.Default.Rule
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0055_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0055_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0055_vector_insufficient_response_strategy_secure,
        msgSecureRes = R.string.maswe_0055_msg_insufficient_response_strategy_secure,
        icon = Icons.Default.PhoneIphone
    );

    override val masweId = "MASWE-0055"
    override val screenTitleSecureRes = R.string.maswe_0055_secure_title
    override val screenDescSecureRes = R.string.maswe_0055_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0055_secure_vectors_title
}
