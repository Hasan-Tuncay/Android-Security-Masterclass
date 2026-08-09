package com.hasantuncay.mobsec.maswe0043.common

import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Vector
import com.hasantuncay.mobsec.maswe0043.common.Maswe0043Mitigation
import com.hasantuncay.mobsec.maswe0043.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0043Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_ENFORCED_UPDATE_MECHANISM(
        titleRes = R.string.maswe_0043_vector_no_enforced_update_mechanism_vuln,
        msgRes = R.string.maswe_0043_msg_no_enforced_update_mechanism_vuln,
        icon = Icons.Default.SystemUpdateAlt
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0043",
            titleRes = CommonR.string.maswe_0043_vuln_title,
            descRes = CommonR.string.maswe_0043_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0043_vuln_vectors_title
        )
    }
}
