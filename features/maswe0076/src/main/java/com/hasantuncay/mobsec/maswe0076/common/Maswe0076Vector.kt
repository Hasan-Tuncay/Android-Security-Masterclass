package com.hasantuncay.mobsec.maswe0076.common

import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Vector
import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Mitigation
import com.hasantuncay.mobsec.maswe0076.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0076Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DATA_MANAGEMENT(
        titleRes = R.string.maswe_0076_vector_vuln,
        msgRes = R.string.maswe_0076_msg_vuln,
        icon = Icons.Default.Storage
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0076",
            titleRes = CommonR.string.maswe_0076_vuln_title,
            descRes = CommonR.string.maswe_0076_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0076_vuln_vectors_title
        )
    }
}
