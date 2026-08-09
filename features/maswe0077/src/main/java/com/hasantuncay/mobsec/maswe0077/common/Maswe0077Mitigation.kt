package com.hasantuncay.mobsec.maswe0077.common

import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Vector
import com.hasantuncay.mobsec.maswe0077.common.Maswe0077Mitigation
import com.hasantuncay.mobsec.maswe0077.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0077Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DATA_VISIBILITY(
        titleRes = R.string.maswe_0077_vector_secure,
        msgRes = R.string.maswe_0077_msg_secure,
        icon = Icons.Default.VisibilityOff
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0077",
            titleRes = CommonR.string.maswe_0077_secure_title,
            descRes = CommonR.string.maswe_0077_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0077_secure_vectors_title
        )
    }
}
