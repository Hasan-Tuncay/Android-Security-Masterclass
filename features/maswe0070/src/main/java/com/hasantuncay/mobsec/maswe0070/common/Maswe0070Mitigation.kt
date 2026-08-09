package com.hasantuncay.mobsec.maswe0070.common

import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Vector
import com.hasantuncay.mobsec.maswe0070.common.Maswe0070Mitigation
import com.hasantuncay.mobsec.maswe0070.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0070Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    IMPLICIT_INTENTS(
        titleRes = R.string.maswe_0070_vector_secure,
        msgRes = R.string.maswe_0070_msg_secure,
        icon = Icons.Default.Share
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0070",
            titleRes = CommonR.string.maswe_0070_secure_title,
            descRes = CommonR.string.maswe_0070_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0070_secure_vectors_title
        )
    }
}
