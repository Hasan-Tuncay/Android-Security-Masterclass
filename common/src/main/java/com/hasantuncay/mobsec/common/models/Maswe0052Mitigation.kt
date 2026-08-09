package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0052Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_VIRTUALIZATION_CHECKS(
        titleSecureRes = R.string.maswe_0052_vector_no_virtualization_checks_secure,
        msgSecureRes = R.string.maswe_0052_msg_no_virtualization_checks_secure,
        icon = Icons.Default.LaptopWindows
    ),
    KNOWN_FRAMEWORKS_NOT_DETECTED(
        titleSecureRes = R.string.maswe_0052_vector_known_frameworks_not_detected_secure,
        msgSecureRes = R.string.maswe_0052_msg_known_frameworks_not_detected_secure,
        icon = Icons.Default.Warning
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0052_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0052_msg_no_response_strategy_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0052"
    override val screenTitleSecureRes = R.string.maswe_0052_secure_title
    override val screenDescSecureRes = R.string.maswe_0052_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0052_secure_vectors_title
}
