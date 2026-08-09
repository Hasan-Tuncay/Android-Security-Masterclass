package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0027: Insecure Certificate Validation
 */
enum class Maswe0027Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DISABLING_CERT_VALIDATION(
        titleVulnRes = R.string.maswe_0027_vector_disabling_cert_validation_vuln,
        msgVulnRes = R.string.maswe_0027_msg_disabling_cert_validation_vuln,
        icon = Icons.Default.Block
    ),
    ACCEPTING_SELF_SIGNED_CERTS(
        titleVulnRes = R.string.maswe_0027_vector_accepting_self_signed_certs_vuln,
        msgVulnRes = R.string.maswe_0027_msg_accepting_self_signed_certs_vuln,
        icon = Icons.Default.Warning
    ),
    IGNORING_HOSTNAME_VERIFICATION(
        titleVulnRes = R.string.maswe_0027_vector_ignoring_hostname_verification_vuln,
        msgVulnRes = R.string.maswe_0027_msg_ignoring_hostname_verification_vuln,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_CUSTOM_TRUST_MANAGER(
        titleVulnRes = R.string.maswe_0027_vector_insecure_custom_trust_manager_vuln,
        msgVulnRes = R.string.maswe_0027_msg_insecure_custom_trust_manager_vuln,
        icon = Icons.Default.BugReport
    ),
    INCORRECT_ERROR_HANDLING(
        titleVulnRes = R.string.maswe_0027_vector_incorrect_error_handling_vuln,
        msgVulnRes = R.string.maswe_0027_msg_incorrect_error_handling_vuln,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleVulnRes = R.string.maswe_0027_vector_third_party_library_vuln,
        msgVulnRes = R.string.maswe_0027_msg_third_party_library_vuln,
        icon = Icons.Default.Code
    );

    override val masweId = "MASWE-0027"
    override val screenTitleVulnRes = R.string.maswe_0027_vuln_title
    override val screenDescVulnRes = R.string.maswe_0027_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0027_vuln_vectors_title
}
