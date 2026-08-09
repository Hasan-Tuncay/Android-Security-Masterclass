package com.hasantuncay.mobsec.maswe0068.common

import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Vector
import com.hasantuncay.mobsec.maswe0068.common.Maswe0068Mitigation
import com.hasantuncay.mobsec.maswe0068.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0068Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RECENT_APPS_LEAK(
        titleRes = R.string.maswe_0068_vector_secure,
        msgRes = R.string.maswe_0068_msg_secure,
        icon = Icons.Default.Visibility
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0068",
            titleRes = CommonR.string.maswe_0068_secure_title,
            descRes = CommonR.string.maswe_0068_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0068_secure_vectors_title
        )
    }
}
