package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0027: Insecure Certificate Validation
 */
enum class Maswe0027Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DISABLING_CERT_VALIDATION(
        titleSecureRes = R.string.maswe_0027_vector_disabling_cert_validation_secure,
        msgSecureRes = R.string.maswe_0027_msg_disabling_cert_validation_secure,
        icon = Icons.Default.Block
    ),
    ACCEPTING_SELF_SIGNED_CERTS(
        titleSecureRes = R.string.maswe_0027_vector_accepting_self_signed_certs_secure,
        msgSecureRes = R.string.maswe_0027_msg_accepting_self_signed_certs_secure,
        icon = Icons.Default.Warning
    ),
    IGNORING_HOSTNAME_VERIFICATION(
        titleSecureRes = R.string.maswe_0027_vector_ignoring_hostname_verification_secure,
        msgSecureRes = R.string.maswe_0027_msg_ignoring_hostname_verification_secure,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_CUSTOM_TRUST_MANAGER(
        titleSecureRes = R.string.maswe_0027_vector_insecure_custom_trust_manager_secure,
        msgSecureRes = R.string.maswe_0027_msg_insecure_custom_trust_manager_secure,
        icon = Icons.Default.BugReport
    ),
    INCORRECT_ERROR_HANDLING(
        titleSecureRes = R.string.maswe_0027_vector_incorrect_error_handling_secure,
        msgSecureRes = R.string.maswe_0027_msg_incorrect_error_handling_secure,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleSecureRes = R.string.maswe_0027_vector_third_party_library_secure,
        msgSecureRes = R.string.maswe_0027_msg_third_party_library_secure,
        icon = Icons.Default.Code
    );

    override val masweId = "MASWE-0027"
    override val screenTitleSecureRes = R.string.maswe_0027_secure_title
    override val screenDescSecureRes = R.string.maswe_0027_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0027_secure_vectors_title
}
