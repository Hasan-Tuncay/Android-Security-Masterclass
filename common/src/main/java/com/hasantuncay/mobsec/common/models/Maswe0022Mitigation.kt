package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0022Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    INVALIDATION_DISABLED(
        titleSecureRes = R.string.maswe_0022_vector_invalidation_disabled_secure,
        msgSecureRes = R.string.maswe_0022_msg_invalidation_disabled_secure,
        icon = Icons.Default.Warning
    ),
    INVALIDATION_NOT_ENABLED(
        titleSecureRes = R.string.maswe_0022_vector_invalidation_not_enabled_secure,
        msgSecureRes = R.string.maswe_0022_msg_invalidation_not_enabled_secure,
        icon = Icons.Default.Key
    ),
    UNSAFE_INVALIDATION_RECOVERY(
        titleSecureRes = R.string.maswe_0022_vector_unsafe_invalidation_recovery_secure,
        msgSecureRes = R.string.maswe_0022_msg_unsafe_invalidation_recovery_secure,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0022"
    override val screenTitleSecureRes = R.string.maswe_0022_secure_title
    override val screenDescSecureRes = R.string.maswe_0022_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0022_secure_vectors_title
}
