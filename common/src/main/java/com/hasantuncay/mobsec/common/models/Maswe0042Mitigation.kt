package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0042Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    OUTDATED_TARGET_VERSION(
        titleSecureRes = R.string.maswe_0042_vector_outdated_target_version_secure,
        msgSecureRes = R.string.maswe_0042_msg_outdated_target_version_secure,
        icon = Icons.Default.SystemUpdate
    ),
    COMPATIBILITY_BEHAVIORS_LEFT(
        titleSecureRes = R.string.maswe_0042_vector_compatibility_behaviors_left_secure,
        msgSecureRes = R.string.maswe_0042_msg_compatibility_behaviors_left_secure,
        icon = Icons.Default.Build
    );

    override val masweId = "MASWE-0042"
    override val screenTitleSecureRes = R.string.maswe_0042_secure_title
    override val screenDescSecureRes = R.string.maswe_0042_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0042_secure_vectors_title
}
