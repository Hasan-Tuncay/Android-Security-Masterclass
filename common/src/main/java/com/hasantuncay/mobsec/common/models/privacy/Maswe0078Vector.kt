package com.hasantuncay.mobsec.common.models.privacy

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0078Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    AMBIGUOUS_CONSENT(
        titleRes = R.string.maswe_0078_vector_vuln,
        msgRes = R.string.maswe_0078_msg_vuln,
        icon = Icons.Default.FactCheck
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0078",
            titleRes = R.string.maswe_0078_vuln_title,
            descRes = R.string.maswe_0078_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0078_vuln_vectors_title
        )
    }
}
