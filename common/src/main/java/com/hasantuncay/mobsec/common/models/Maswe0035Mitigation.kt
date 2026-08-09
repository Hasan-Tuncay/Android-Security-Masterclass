package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0035Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    UNRESTRICTED_NAVIGATION(
        titleSecureRes = R.string.maswe_0035_vector_unrestricted_navigation_secure,
        msgSecureRes = R.string.maswe_0035_msg_unrestricted_navigation_secure,
        icon = Icons.Default.Explore
    ),
    UNTRUSTED_URLS_FROM_EXTERNAL(
        titleSecureRes = R.string.maswe_0035_vector_untrusted_urls_from_external_secure,
        msgSecureRes = R.string.maswe_0035_msg_untrusted_urls_from_external_secure,
        icon = Icons.Default.Link
    ),
    UNTRUSTED_SCRIPT_INCLUSION(
        titleSecureRes = R.string.maswe_0035_vector_untrusted_script_inclusion_secure,
        msgSecureRes = R.string.maswe_0035_msg_untrusted_script_inclusion_secure,
        icon = Icons.Default.Javascript
    ),
    SAFE_BROWSING_DISABLED(
        titleSecureRes = R.string.maswe_0035_vector_safe_browsing_disabled_secure,
        msgSecureRes = R.string.maswe_0035_msg_safe_browsing_disabled_secure,
        icon = Icons.Default.SecurityUpdateWarning
    ),
    DEPRECATED_WEBVIEW_COMPONENTS(
        titleSecureRes = R.string.maswe_0035_vector_deprecated_webview_components_secure,
        msgSecureRes = R.string.maswe_0035_msg_deprecated_webview_components_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0035"
    override val screenTitleSecureRes = R.string.maswe_0035_secure_title
    override val screenDescSecureRes = R.string.maswe_0035_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0035_secure_vectors_title
}
