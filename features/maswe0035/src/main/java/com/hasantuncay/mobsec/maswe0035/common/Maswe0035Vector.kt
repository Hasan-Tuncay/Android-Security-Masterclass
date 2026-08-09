package com.hasantuncay.mobsec.maswe0035.common

import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Vector
import com.hasantuncay.mobsec.maswe0035.common.Maswe0035Mitigation
import com.hasantuncay.mobsec.maswe0035.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0035Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    UNRESTRICTED_NAVIGATION(
        titleRes = R.string.maswe_0035_vector_unrestricted_navigation_vuln,
        msgRes = R.string.maswe_0035_msg_unrestricted_navigation_vuln,
        icon = Icons.Default.Explore
    ),
    UNTRUSTED_URLS_FROM_EXTERNAL(
        titleRes = R.string.maswe_0035_vector_untrusted_urls_from_external_vuln,
        msgRes = R.string.maswe_0035_msg_untrusted_urls_from_external_vuln,
        icon = Icons.Default.Link
    ),
    UNTRUSTED_SCRIPT_INCLUSION(
        titleRes = R.string.maswe_0035_vector_untrusted_script_inclusion_vuln,
        msgRes = R.string.maswe_0035_msg_untrusted_script_inclusion_vuln,
        icon = Icons.Default.Javascript
    ),
    SAFE_BROWSING_DISABLED(
        titleRes = R.string.maswe_0035_vector_safe_browsing_disabled_vuln,
        msgRes = R.string.maswe_0035_msg_safe_browsing_disabled_vuln,
        icon = Icons.Default.SecurityUpdateWarning
    ),
    DEPRECATED_WEBVIEW_COMPONENTS(
        titleRes = R.string.maswe_0035_vector_deprecated_webview_components_vuln,
        msgRes = R.string.maswe_0035_msg_deprecated_webview_components_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0035",
            titleRes = CommonR.string.maswe_0035_vuln_title,
            descRes = CommonR.string.maswe_0035_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0035_vuln_vectors_title
        )
    }
}
