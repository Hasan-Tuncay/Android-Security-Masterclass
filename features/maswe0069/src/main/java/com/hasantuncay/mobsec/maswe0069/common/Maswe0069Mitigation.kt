package com.hasantuncay.mobsec.maswe0069.common

import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Vector
import com.hasantuncay.mobsec.maswe0069.common.Maswe0069Mitigation
import com.hasantuncay.mobsec.maswe0069.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0069Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    CLIPBOARD_EXPOSURE(
        titleRes = R.string.maswe_0069_vector_secure,
        msgRes = R.string.maswe_0069_msg_secure,
        icon = Icons.Default.ContentCopy
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0069",
            titleRes = CommonR.string.maswe_0069_secure_title,
            descRes = CommonR.string.maswe_0069_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0069_secure_vectors_title
        )
    }
}
