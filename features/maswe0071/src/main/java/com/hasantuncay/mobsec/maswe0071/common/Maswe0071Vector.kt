package com.hasantuncay.mobsec.maswe0071.common

import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Vector
import com.hasantuncay.mobsec.maswe0071.common.Maswe0071Mitigation
import com.hasantuncay.mobsec.maswe0071.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0071Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INADEQUATE_DEFAULTS(
        titleRes = R.string.maswe_0071_vector_vuln,
        msgRes = R.string.maswe_0071_msg_vuln,
        icon = Icons.Default.Settings
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0071",
            titleRes = CommonR.string.maswe_0071_vuln_title,
            descRes = CommonR.string.maswe_0071_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0071_vuln_vectors_title
        )
    }
}
