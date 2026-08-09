package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0046Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DEPRECATED_CRYPTOGRAPHIC_PROVIDERS(
        titleVulnRes = R.string.maswe_0046_vector_deprecated_cryptographic_providers_vuln,
        msgVulnRes = R.string.maswe_0046_msg_deprecated_cryptographic_providers_vuln,
        icon = Icons.Default.NoEncryption
    ),
    DEPRECATED_PLATFORM_APIS(
        titleVulnRes = R.string.maswe_0046_vector_deprecated_platform_apis_vuln,
        msgVulnRes = R.string.maswe_0046_msg_deprecated_platform_apis_vuln,
        icon = Icons.Default.Api
    ),
    DEPRECATION_WARNINGS_IGNORED(
        titleVulnRes = R.string.maswe_0046_vector_deprecation_warnings_ignored_vuln,
        msgVulnRes = R.string.maswe_0046_msg_deprecation_warnings_ignored_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0046"
    override val screenTitleVulnRes = R.string.maswe_0046_vuln_title
    override val screenDescVulnRes = R.string.maswe_0046_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0046_vuln_vectors_title
}
