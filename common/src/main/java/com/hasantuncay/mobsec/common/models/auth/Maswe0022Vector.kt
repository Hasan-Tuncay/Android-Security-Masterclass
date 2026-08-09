package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0022Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INVALIDATION_DISABLED(
        titleRes = R.string.maswe_0022_vector_invalidation_disabled_vuln,
        msgRes = R.string.maswe_0022_msg_invalidation_disabled_vuln,
        icon = Icons.Default.Warning
    ),
    INVALIDATION_NOT_ENABLED(
        titleRes = R.string.maswe_0022_vector_invalidation_not_enabled_vuln,
        msgRes = R.string.maswe_0022_msg_invalidation_not_enabled_vuln,
        icon = Icons.Default.Key
    ),
    UNSAFE_INVALIDATION_RECOVERY(
        titleRes = R.string.maswe_0022_vector_unsafe_invalidation_recovery_vuln,
        msgRes = R.string.maswe_0022_msg_unsafe_invalidation_recovery_vuln,
        icon = Icons.Default.BugReport
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0022",
            titleRes = R.string.maswe_0022_vuln_title,
            descRes = R.string.maswe_0022_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0022_vuln_vectors_title
        )
    }
}
