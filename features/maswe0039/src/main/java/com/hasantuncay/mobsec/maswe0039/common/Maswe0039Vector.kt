package com.hasantuncay.mobsec.maswe0039.common

import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Vector
import com.hasantuncay.mobsec.maswe0039.common.Maswe0039Mitigation
import com.hasantuncay.mobsec.maswe0039.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0039Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    TOUCH_FILTERING_NOT_ENABLED(
        titleRes = R.string.maswe_0039_vector_touch_filtering_not_enabled_vuln,
        msgRes = R.string.maswe_0039_msg_touch_filtering_not_enabled_vuln,
        icon = Icons.Default.TouchApp
    ),
    EXTERNAL_OVERLAYS_NOT_HIDDEN(
        titleRes = R.string.maswe_0039_vector_external_overlays_not_hidden_vuln,
        msgRes = R.string.maswe_0039_msg_external_overlays_not_hidden_vuln,
        icon = Icons.Default.Layers
    ),
    SENSITIVE_SCREENS_NOT_PROTECTED(
        titleRes = R.string.maswe_0039_vector_sensitive_screens_not_protected_vuln,
        msgRes = R.string.maswe_0039_msg_sensitive_screens_not_protected_vuln,
        icon = Icons.Default.Security
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0039",
            titleRes = CommonR.string.maswe_0039_vuln_title,
            descRes = CommonR.string.maswe_0039_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0039_vuln_vectors_title
        )
    }
}
