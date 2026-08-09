package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0064Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_DEBUGGER_CHECKS(
        titleSecureRes = R.string.maswe_0064_vector_no_debugger_checks_secure,
        msgSecureRes = R.string.maswe_0064_msg_no_debugger_checks_secure,
        icon = Icons.Default.PestControl
    ),
    ONE_TIME_CHECKS(
        titleSecureRes = R.string.maswe_0064_vector_one_time_checks_secure,
        msgSecureRes = R.string.maswe_0064_msg_one_time_checks_secure,
        icon = Icons.Default.AvTimer
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0064_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0064_msg_no_response_strategy_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0064"
    override val screenTitleSecureRes = R.string.maswe_0064_secure_title
    override val screenDescSecureRes = R.string.maswe_0064_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0064_secure_vectors_title
}
