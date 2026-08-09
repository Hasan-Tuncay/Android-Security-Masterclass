package com.hasantuncay.mobsec.common.models.privacy

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0069Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    CLIPBOARD_EXPOSURE(
        titleRes = R.string.maswe_0069_vector_vuln,
        msgRes = R.string.maswe_0069_msg_vuln,
        icon = Icons.Default.ContentCopy
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0069",
            titleRes = R.string.maswe_0069_vuln_title,
            descRes = R.string.maswe_0069_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0069_vuln_vectors_title
        )
    }
}
