package com.hasantuncay.mobsec.maswe0022.common

import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Vector
import com.hasantuncay.mobsec.maswe0022.common.Maswe0022Mitigation
import com.hasantuncay.mobsec.maswe0022.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0022Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    INVALIDATION_DISABLED(
        titleRes = R.string.maswe_0022_vector_invalidation_disabled_secure,
        msgRes = R.string.maswe_0022_msg_invalidation_disabled_secure,
        icon = Icons.Default.Warning
    ),
    INVALIDATION_NOT_ENABLED(
        titleRes = R.string.maswe_0022_vector_invalidation_not_enabled_secure,
        msgRes = R.string.maswe_0022_msg_invalidation_not_enabled_secure,
        icon = Icons.Default.Key
    ),
    UNSAFE_INVALIDATION_RECOVERY(
        titleRes = R.string.maswe_0022_vector_unsafe_invalidation_recovery_secure,
        msgRes = R.string.maswe_0022_msg_unsafe_invalidation_recovery_secure,
        icon = Icons.Default.BugReport
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0022",
            titleRes = CommonR.string.maswe_0022_secure_title,
            descRes = CommonR.string.maswe_0022_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0022_secure_vectors_title
        )
    }
}
