package com.hasantuncay.mobsec.maswe0029.common

import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Vector
import com.hasantuncay.mobsec.maswe0029.common.Maswe0029Mitigation
import com.hasantuncay.mobsec.maswe0029.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0029Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNVERIFIED_CUSTOM_URL_SCHEME(
        titleRes = R.string.maswe_0029_vector_unverified_custom_url_scheme_vuln,
        msgRes = R.string.maswe_0029_msg_unverified_custom_url_scheme_vuln,
        icon = Icons.Default.Link
    ),
    MISSING_DOMAIN_ASSOCIATION(
        titleRes = R.string.maswe_0029_vector_missing_domain_association_vuln,
        msgRes = R.string.maswe_0029_msg_missing_domain_association_vuln,
        icon = Icons.Default.LinkOff
    ),
    UNVALIDATED_DEEP_LINK_INPUT(
        titleRes = R.string.maswe_0029_vector_unvalidated_deep_link_input_vuln,
        msgRes = R.string.maswe_0029_msg_unvalidated_deep_link_input_vuln,
        icon = Icons.Default.BugReport
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0029",
            titleRes = CommonR.string.maswe_0029_vuln_title,
            descRes = CommonR.string.maswe_0029_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0029_vuln_vectors_title
        )
    }
}
