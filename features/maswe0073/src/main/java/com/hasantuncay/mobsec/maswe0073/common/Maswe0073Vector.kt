package com.hasantuncay.mobsec.maswe0073.common

import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Vector
import com.hasantuncay.mobsec.maswe0073.common.Maswe0073Mitigation
import com.hasantuncay.mobsec.maswe0073.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0073Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DATA_COLLECTION_DECL(
        titleRes = R.string.maswe_0073_vector_vuln,
        msgRes = R.string.maswe_0073_msg_vuln,
        icon = Icons.Default.DataUsage
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0073",
            titleRes = CommonR.string.maswe_0073_vuln_title,
            descRes = CommonR.string.maswe_0073_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0073_vuln_vectors_title
        )
    }
}
