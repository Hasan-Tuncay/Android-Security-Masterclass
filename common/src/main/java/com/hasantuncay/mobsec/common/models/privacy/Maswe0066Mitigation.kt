package com.hasantuncay.mobsec.common.models.privacy

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0066Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    BROAD_PERMISSIONS(
        titleRes = R.string.maswe_0066_vector_secure,
        msgRes = R.string.maswe_0066_msg_secure,
        icon = Icons.Default.Security
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0066",
            titleRes = R.string.maswe_0066_secure_title,
            descRes = R.string.maswe_0066_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0066_secure_vectors_title
        )
    }
}
