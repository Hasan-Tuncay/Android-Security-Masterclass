package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0062Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    TLS_ONLY_PROTECTION(
        titleVulnRes = R.string.maswe_0062_vector_tls_only_protection_vuln,
        msgVulnRes = R.string.maswe_0062_msg_tls_only_protection_vuln,
        icon = Icons.Default.VpnKey
    ),
    NO_INTEGRITY_BINDING_ON_REQUESTS(
        titleVulnRes = R.string.maswe_0062_vector_no_integrity_binding_on_requests_vuln,
        msgVulnRes = R.string.maswe_0062_msg_no_integrity_binding_on_requests_vuln,
        icon = Icons.Default.LinkOff
    );

    override val masweId = "MASWE-0062"
    override val screenTitleVulnRes = R.string.maswe_0062_vuln_title
    override val screenDescVulnRes = R.string.maswe_0062_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0062_vuln_vectors_title
}
