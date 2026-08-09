package com.hasantuncay.mobsec.maswe0067.common

import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Vector
import com.hasantuncay.mobsec.maswe0067.common.Maswe0067Mitigation
import com.hasantuncay.mobsec.maswe0067.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0067Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    CUSTOM_KEYBOARD(
        titleRes = R.string.maswe_0067_vector_secure,
        msgRes = R.string.maswe_0067_msg_secure,
        icon = Icons.Default.Keyboard
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0067",
            titleRes = CommonR.string.maswe_0067_secure_title,
            descRes = CommonR.string.maswe_0067_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0067_secure_vectors_title
        )
    }
}
