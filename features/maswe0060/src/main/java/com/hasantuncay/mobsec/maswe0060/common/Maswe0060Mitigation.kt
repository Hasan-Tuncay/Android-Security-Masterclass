package com.hasantuncay.mobsec.maswe0060.common

import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Vector
import com.hasantuncay.mobsec.maswe0060.common.Maswe0060Mitigation
import com.hasantuncay.mobsec.maswe0060.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0060Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RESOURCES_LEFT_IN_CLEAR(
        titleRes = R.string.maswe_0060_vector_resources_left_in_clear_secure,
        msgRes = R.string.maswe_0060_msg_resources_left_in_clear_secure,
        icon = Icons.Default.Image
    ),
    IDENTIFIERS_LEFT_MEANINGFUL(
        titleRes = R.string.maswe_0060_vector_identifiers_left_meaningful_secure,
        msgRes = R.string.maswe_0060_msg_identifiers_left_meaningful_secure,
        icon = Icons.Default.TextFormat
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0060",
            titleRes = CommonR.string.maswe_0060_secure_title,
            descRes = CommonR.string.maswe_0060_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0060_secure_vectors_title
        )
    }
}
