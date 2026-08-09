package com.hasantuncay.mobsec.maswe0075.common

import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Vector
import com.hasantuncay.mobsec.maswe0075.common.Maswe0075Mitigation
import com.hasantuncay.mobsec.maswe0075.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0075Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NON_REPRODUCIBLE(
        titleRes = R.string.maswe_0075_vector_vuln,
        msgRes = R.string.maswe_0075_msg_vuln,
        icon = Icons.Default.Build
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0075",
            titleRes = CommonR.string.maswe_0075_vuln_title,
            descRes = CommonR.string.maswe_0075_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0075_vuln_vectors_title
        )
    }
}
