package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0026: Network Traffic Not Encrypted
 */
enum class Maswe0026Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    CLEARTEXT_ALLOWED_IN_NSC(
        titleVulnRes = R.string.maswe_0026_vector_cleartext_allowed_in_nsc_vuln,
        msgVulnRes = R.string.maswe_0026_msg_cleartext_allowed_in_nsc_vuln,
        icon = Icons.Default.NoEncryption
    ),
    HTTP_INSTEAD_OF_HTTPS(
        titleVulnRes = R.string.maswe_0026_vector_http_instead_of_https_vuln,
        msgVulnRes = R.string.maswe_0026_msg_http_instead_of_https_vuln,
        icon = Icons.Default.Warning
    ),
    NON_HTTP_INSECURE_PROTOCOL(
        titleVulnRes = R.string.maswe_0026_vector_non_http_insecure_protocol_vuln,
        msgVulnRes = R.string.maswe_0026_msg_non_http_insecure_protocol_vuln,
        icon = Icons.Default.Block
    ),
    UNENCRYPTED_M2M_CHANNEL(
        titleVulnRes = R.string.maswe_0026_vector_unencrypted_m2m_channel_vuln,
        msgVulnRes = R.string.maswe_0026_msg_unencrypted_m2m_channel_vuln,
        icon = Icons.Default.Bluetooth
    ),
    LOW_LEVEL_NETWORK_API(
        titleVulnRes = R.string.maswe_0026_vector_low_level_network_api_vuln,
        msgVulnRes = R.string.maswe_0026_msg_low_level_network_api_vuln,
        icon = Icons.Default.Code
    ),
    CROSS_PLATFORM_MISCONFIGURATION(
        titleVulnRes = R.string.maswe_0026_vector_cross_platform_misconfiguration_vuln,
        msgVulnRes = R.string.maswe_0026_msg_cross_platform_misconfiguration_vuln,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleVulnRes = R.string.maswe_0026_vector_third_party_library_vuln,
        msgVulnRes = R.string.maswe_0026_msg_third_party_library_vuln,
        icon = Icons.Default.BugReport
    );

    override val masweId = "MASWE-0026"
    override val screenTitleVulnRes = R.string.maswe_0026_vuln_title
    override val screenDescVulnRes = R.string.maswe_0026_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0026_vuln_vectors_title
}
