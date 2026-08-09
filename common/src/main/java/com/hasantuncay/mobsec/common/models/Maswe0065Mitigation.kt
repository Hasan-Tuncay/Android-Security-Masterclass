package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0065Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_INSTRUMENTATION_CHECKS(
        titleSecureRes = R.string.maswe_0065_vector_no_instrumentation_checks_secure,
        msgSecureRes = R.string.maswe_0065_msg_no_instrumentation_checks_secure,
        icon = Icons.Default.AutoFixOff
    ),
    ARTIFACT_CHECKS_MISSING(
        titleSecureRes = R.string.maswe_0065_vector_artifact_checks_missing_secure,
        msgSecureRes = R.string.maswe_0065_msg_artifact_checks_missing_secure,
        icon = Icons.Default.FactCheck
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0065_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0065_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0065"
    override val screenTitleSecureRes = R.string.maswe_0065_secure_title
    override val screenDescSecureRes = R.string.maswe_0065_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0065_secure_vectors_title
}
