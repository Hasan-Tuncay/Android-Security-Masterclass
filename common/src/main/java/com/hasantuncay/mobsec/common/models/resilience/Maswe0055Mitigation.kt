package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0055Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_HOSTILE_ENVIRONMENT_CHECKS(
        titleRes = R.string.maswe_0055_vector_no_hostile_environment_checks_secure,
        msgRes = R.string.maswe_0055_msg_no_hostile_environment_checks_secure,
        icon = Icons.Default.PestControl
    ),
    ABUSE_PRONE_CAPABILITIES_IGNORED(
        titleRes = R.string.maswe_0055_vector_abuse_prone_capabilities_ignored_secure,
        msgRes = R.string.maswe_0055_msg_abuse_prone_capabilities_ignored_secure,
        icon = Icons.Default.Rule
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0055_vector_no_response_strategy_secure,
        msgRes = R.string.maswe_0055_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0055_vector_insufficient_response_strategy_secure,
        msgRes = R.string.maswe_0055_msg_insufficient_response_strategy_secure,
        icon = Icons.Default.PhoneIphone
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0055",
            titleRes = R.string.maswe_0055_secure_title,
            descRes = R.string.maswe_0055_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0055_secure_vectors_title
        )
    }
}
