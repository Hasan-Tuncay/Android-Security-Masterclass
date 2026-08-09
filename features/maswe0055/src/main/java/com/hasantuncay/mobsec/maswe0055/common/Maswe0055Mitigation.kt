package com.hasantuncay.mobsec.maswe0055.common

import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Vector
import com.hasantuncay.mobsec.maswe0055.common.Maswe0055Mitigation
import com.hasantuncay.mobsec.maswe0055.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
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
        icon = Icons.AutoMirrored.Filled.Rule
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
            titleRes = CommonR.string.maswe_0055_secure_title,
            descRes = CommonR.string.maswe_0055_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0055_secure_vectors_title
        )
    }
}
