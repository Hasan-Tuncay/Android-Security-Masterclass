package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0029Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    UNVERIFIED_CUSTOM_URL_SCHEME(
        titleRes = R.string.maswe_0029_vector_unverified_custom_url_scheme_secure,
        msgRes = R.string.maswe_0029_msg_unverified_custom_url_scheme_secure,
        icon = Icons.Default.Link
    ),
    MISSING_DOMAIN_ASSOCIATION(
        titleRes = R.string.maswe_0029_vector_missing_domain_association_secure,
        msgRes = R.string.maswe_0029_msg_missing_domain_association_secure,
        icon = Icons.Default.LinkOff
    ),
    UNVALIDATED_DEEP_LINK_INPUT(
        titleRes = R.string.maswe_0029_vector_unvalidated_deep_link_input_secure,
        msgRes = R.string.maswe_0029_msg_unvalidated_deep_link_input_secure,
        icon = Icons.Default.BugReport
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0029",
            titleRes = R.string.maswe_0029_secure_title,
            descRes = R.string.maswe_0029_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0029_secure_vectors_title
        )
    }
}
