package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0065Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_INSTRUMENTATION_CHECKS(
        titleVulnRes = R.string.maswe_0065_vector_no_instrumentation_checks_vuln,
        msgVulnRes = R.string.maswe_0065_msg_no_instrumentation_checks_vuln,
        icon = Icons.Default.AutoFixOff
    ),
    ARTIFACT_CHECKS_MISSING(
        titleVulnRes = R.string.maswe_0065_vector_artifact_checks_missing_vuln,
        msgVulnRes = R.string.maswe_0065_msg_artifact_checks_missing_vuln,
        icon = Icons.Default.FactCheck
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0065_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0065_msg_no_response_strategy_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0065"
    override val screenTitleVulnRes = R.string.maswe_0065_vuln_title
    override val screenDescVulnRes = R.string.maswe_0065_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0065_vuln_vectors_title
}
