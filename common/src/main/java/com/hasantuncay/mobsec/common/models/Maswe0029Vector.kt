package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0029Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNVERIFIED_CUSTOM_URL_SCHEME(
        titleVulnRes = R.string.maswe_0029_vector_unverified_custom_url_scheme_vuln,
        msgVulnRes = R.string.maswe_0029_msg_unverified_custom_url_scheme_vuln,
        icon = Icons.Default.Link
    ),
    MISSING_DOMAIN_ASSOCIATION(
        titleVulnRes = R.string.maswe_0029_vector_missing_domain_association_vuln,
        msgVulnRes = R.string.maswe_0029_msg_missing_domain_association_vuln,
        icon = Icons.Default.LinkOff
    ),
    UNVALIDATED_DEEP_LINK_INPUT(
        titleVulnRes = R.string.maswe_0029_vector_unvalidated_deep_link_input_vuln,
        msgVulnRes = R.string.maswe_0029_msg_unvalidated_deep_link_input_vuln,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0029"
    override val screenTitleVulnRes = R.string.maswe_0029_vuln_title
    override val screenDescVulnRes = R.string.maswe_0029_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0029_vuln_vectors_title
}
