package com.hasantuncay.mobsec.maswe0042.common

import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Vector
import com.hasantuncay.mobsec.maswe0042.common.Maswe0042Mitigation
import com.hasantuncay.mobsec.maswe0042.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0042Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    OUTDATED_TARGET_VERSION(
        titleRes = R.string.maswe_0042_vector_outdated_target_version_vuln,
        msgRes = R.string.maswe_0042_msg_outdated_target_version_vuln,
        icon = Icons.Default.SystemUpdate
    ),
    COMPATIBILITY_BEHAVIORS_LEFT(
        titleRes = R.string.maswe_0042_vector_compatibility_behaviors_left_vuln,
        msgRes = R.string.maswe_0042_msg_compatibility_behaviors_left_vuln,
        icon = Icons.Default.Build
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0042",
            titleRes = CommonR.string.maswe_0042_vuln_title,
            descRes = CommonR.string.maswe_0042_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0042_vuln_vectors_title
        )
    }
}
