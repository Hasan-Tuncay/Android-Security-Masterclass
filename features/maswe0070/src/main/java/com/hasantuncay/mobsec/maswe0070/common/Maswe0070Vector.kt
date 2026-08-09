package com.hasantuncay.mobsec.maswe0070.common

import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Vector
import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Mitigation
import com.hasantuncay.mobsec.maswe0070.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0070Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    IMPLICIT_INTENTS(
        titleRes = R.string.maswe_0070_vector_vuln,
        msgRes = R.string.maswe_0070_msg_vuln,
        icon = Icons.Default.Share
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0070",
            titleRes = CommonR.string.maswe_0070_vuln_title,
            descRes = CommonR.string.maswe_0070_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0070_vuln_vectors_title
        )
    }
}
