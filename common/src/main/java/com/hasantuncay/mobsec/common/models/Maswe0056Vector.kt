package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0056Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_PACKAGED_APP_INTEGRITY_VERIFICATION(
        titleVulnRes = R.string.maswe_0056_vector_no_packaged_app_integrity_verification_vuln,
        msgVulnRes = R.string.maswe_0056_msg_no_packaged_app_integrity_verification_vuln,
        icon = Icons.Default.Verified
    ),
    NO_SERVER_VERIFIED_APP_INTEGRITY(
        titleVulnRes = R.string.maswe_0056_vector_no_server_verified_app_integrity_vuln,
        msgVulnRes = R.string.maswe_0056_msg_no_server_verified_app_integrity_vuln,
        icon = Icons.Default.Dns
    ),
    MISSING_SERVER_ATTESTATION_VERIFICATION(
        titleVulnRes = R.string.maswe_0056_vector_missing_server_attestation_verification_vuln,
        msgVulnRes = R.string.maswe_0056_msg_missing_server_attestation_verification_vuln,
        icon = Icons.Default.Storage
    ),
    OUTDATED_SIGNING_SCHEMES(
        titleVulnRes = R.string.maswe_0056_vector_outdated_signing_schemes_vuln,
        msgVulnRes = R.string.maswe_0056_msg_outdated_signing_schemes_vuln,
        icon = Icons.Default.History
    );

    override val masweId = "MASWE-0056"
    override val screenTitleVulnRes = R.string.maswe_0056_vuln_title
    override val screenDescVulnRes = R.string.maswe_0056_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0056_vuln_vectors_title
}
