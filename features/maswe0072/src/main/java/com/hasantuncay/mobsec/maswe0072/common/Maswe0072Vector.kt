package com.hasantuncay.mobsec.maswe0072.common

import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Vector
import com.hasantuncay.mobsec.maswe0072.common.Maswe0072Mitigation
import com.hasantuncay.mobsec.maswe0072.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0072Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INADEQUATE_POLICY(
        titleRes = R.string.maswe_0072_vector_vuln,
        msgRes = R.string.maswe_0072_msg_vuln,
        icon = Icons.Default.Policy
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0072",
            titleRes = CommonR.string.maswe_0072_vuln_title,
            descRes = CommonR.string.maswe_0072_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0072_vuln_vectors_title
        )
    }
}
