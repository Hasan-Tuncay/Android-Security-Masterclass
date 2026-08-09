package com.hasantuncay.mobsec.maswe0074.common

import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Vector
import com.hasantuncay.mobsec.maswe0074.common.Maswe0074Mitigation
import com.hasantuncay.mobsec.maswe0074.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0074Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    TRACKING_DOMAINS(
        titleRes = R.string.maswe_0074_vector_secure,
        msgRes = R.string.maswe_0074_msg_secure,
        icon = Icons.Default.Language
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0074",
            titleRes = CommonR.string.maswe_0074_secure_title,
            descRes = CommonR.string.maswe_0074_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0074_secure_vectors_title
        )
    }
}
