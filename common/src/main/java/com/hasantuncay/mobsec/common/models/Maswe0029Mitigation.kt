package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0029Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    UNVERIFIED_CUSTOM_URL_SCHEME(
        titleSecureRes = R.string.maswe_0029_vector_unverified_custom_url_scheme_secure,
        msgSecureRes = R.string.maswe_0029_msg_unverified_custom_url_scheme_secure,
        icon = Icons.Default.Link
    ),
    MISSING_DOMAIN_ASSOCIATION(
        titleSecureRes = R.string.maswe_0029_vector_missing_domain_association_secure,
        msgSecureRes = R.string.maswe_0029_msg_missing_domain_association_secure,
        icon = Icons.Default.LinkOff
    ),
    UNVALIDATED_DEEP_LINK_INPUT(
        titleSecureRes = R.string.maswe_0029_vector_unvalidated_deep_link_input_secure,
        msgSecureRes = R.string.maswe_0029_msg_unvalidated_deep_link_input_secure,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0029"
    override val screenTitleSecureRes = R.string.maswe_0029_secure_title
    override val screenDescSecureRes = R.string.maswe_0029_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0029_secure_vectors_title
}
