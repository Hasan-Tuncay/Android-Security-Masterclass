package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0035Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNRESTRICTED_NAVIGATION(
        titleVulnRes = R.string.maswe_0035_vector_unrestricted_navigation_vuln,
        msgVulnRes = R.string.maswe_0035_msg_unrestricted_navigation_vuln,
        icon = Icons.Default.Explore
    ),
    UNTRUSTED_URLS_FROM_EXTERNAL(
        titleVulnRes = R.string.maswe_0035_vector_untrusted_urls_from_external_vuln,
        msgVulnRes = R.string.maswe_0035_msg_untrusted_urls_from_external_vuln,
        icon = Icons.Default.Link
    ),
    UNTRUSTED_SCRIPT_INCLUSION(
        titleVulnRes = R.string.maswe_0035_vector_untrusted_script_inclusion_vuln,
        msgVulnRes = R.string.maswe_0035_msg_untrusted_script_inclusion_vuln,
        icon = Icons.Default.Javascript
    ),
    SAFE_BROWSING_DISABLED(
        titleVulnRes = R.string.maswe_0035_vector_safe_browsing_disabled_vuln,
        msgVulnRes = R.string.maswe_0035_msg_safe_browsing_disabled_vuln,
        icon = Icons.Default.SecurityUpdateWarning
    ),
    DEPRECATED_WEBVIEW_COMPONENTS(
        titleVulnRes = R.string.maswe_0035_vector_deprecated_webview_components_vuln,
        msgVulnRes = R.string.maswe_0035_msg_deprecated_webview_components_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0035"
    override val screenTitleVulnRes = R.string.maswe_0035_vuln_title
    override val screenDescVulnRes = R.string.maswe_0035_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0035_vuln_vectors_title
}
