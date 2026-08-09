package com.hasantuncay.mobsec.maswe0076.common

import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Vector
import com.hasantuncay.mobsec.maswe0076.common.Maswe0076Mitigation
import com.hasantuncay.mobsec.maswe0076.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0076Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DATA_MANAGEMENT(
        titleRes = R.string.maswe_0076_vector_secure,
        msgRes = R.string.maswe_0076_msg_secure,
        icon = Icons.Default.Storage
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0076",
            titleRes = CommonR.string.maswe_0076_secure_title,
            descRes = CommonR.string.maswe_0076_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0076_secure_vectors_title
        )
    }
}
