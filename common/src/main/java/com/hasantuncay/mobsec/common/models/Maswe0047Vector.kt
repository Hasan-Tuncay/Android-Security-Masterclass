package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0047Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    ROLL_YOUR_OWN_CRYPTOGRAPHY(
        titleVulnRes = R.string.maswe_0047_vector_roll_your_own_cryptography_vuln,
        msgVulnRes = R.string.maswe_0047_msg_roll_your_own_cryptography_vuln,
        icon = Icons.Default.Build
    ),
    CUSTOM_NETWORKING_TLS_STACKS(
        titleVulnRes = R.string.maswe_0047_vector_custom_networking_tls_stacks_vuln,
        msgVulnRes = R.string.maswe_0047_msg_custom_networking_tls_stacks_vuln,
        icon = Icons.Default.SettingsEthernet
    ),
    CUSTOM_DNS_RESOLUTION(
        titleVulnRes = R.string.maswe_0047_vector_custom_dns_resolution_vuln,
        msgVulnRes = R.string.maswe_0047_msg_custom_dns_resolution_vuln,
        icon = Icons.Default.Dns
    ),
    CUSTOM_AUTHENTICATION(
        titleVulnRes = R.string.maswe_0047_vector_custom_authentication_vuln,
        msgVulnRes = R.string.maswe_0047_msg_custom_authentication_vuln,
        icon = Icons.Default.Lock
    ),
    UNMAINTAINED_SECURITY_LIBRARIES(
        titleVulnRes = R.string.maswe_0047_vector_unmaintained_security_libraries_vuln,
        msgVulnRes = R.string.maswe_0047_msg_unmaintained_security_libraries_vuln,
        icon = Icons.Default.AutoDelete
    );

    override val masweId = "MASWE-0047"
    override val screenTitleVulnRes = R.string.maswe_0047_vuln_title
    override val screenDescVulnRes = R.string.maswe_0047_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0047_vuln_vectors_title
}
