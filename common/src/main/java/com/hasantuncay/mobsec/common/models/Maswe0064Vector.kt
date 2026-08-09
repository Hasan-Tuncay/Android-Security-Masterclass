package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0064Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_DEBUGGER_CHECKS(
        titleVulnRes = R.string.maswe_0064_vector_no_debugger_checks_vuln,
        msgVulnRes = R.string.maswe_0064_msg_no_debugger_checks_vuln,
        icon = Icons.Default.PestControl
    ),
    ONE_TIME_CHECKS(
        titleVulnRes = R.string.maswe_0064_vector_one_time_checks_vuln,
        msgVulnRes = R.string.maswe_0064_msg_one_time_checks_vuln,
        icon = Icons.Default.AvTimer
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0064_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0064_msg_no_response_strategy_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0064"
    override val screenTitleVulnRes = R.string.maswe_0064_vuln_title
    override val screenDescVulnRes = R.string.maswe_0064_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0064_vuln_vectors_title
}
