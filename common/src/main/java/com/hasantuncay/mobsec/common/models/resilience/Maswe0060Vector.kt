package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0060Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    RESOURCES_LEFT_IN_CLEAR(
        titleRes = R.string.maswe_0060_vector_resources_left_in_clear_vuln,
        msgRes = R.string.maswe_0060_msg_resources_left_in_clear_vuln,
        icon = Icons.Default.Image
    ),
    IDENTIFIERS_LEFT_MEANINGFUL(
        titleRes = R.string.maswe_0060_vector_identifiers_left_meaningful_vuln,
        msgRes = R.string.maswe_0060_msg_identifiers_left_meaningful_vuln,
        icon = Icons.Default.TextFormat
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0060",
            titleRes = R.string.maswe_0060_vuln_title,
            descRes = R.string.maswe_0060_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0060_vuln_vectors_title
        )
    }
}
