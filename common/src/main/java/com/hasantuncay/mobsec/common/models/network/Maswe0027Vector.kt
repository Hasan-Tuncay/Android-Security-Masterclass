package com.hasantuncay.mobsec.common.models.network

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0027: Insecure Certificate Validation
 */
enum class Maswe0027Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DISABLING_CERT_VALIDATION(
        titleRes = R.string.maswe_0027_vector_disabling_cert_validation_vuln,
        msgRes = R.string.maswe_0027_msg_disabling_cert_validation_vuln,
        icon = Icons.Default.Block
    ),
    ACCEPTING_SELF_SIGNED_CERTS(
        titleRes = R.string.maswe_0027_vector_accepting_self_signed_certs_vuln,
        msgRes = R.string.maswe_0027_msg_accepting_self_signed_certs_vuln,
        icon = Icons.Default.Warning
    ),
    IGNORING_HOSTNAME_VERIFICATION(
        titleRes = R.string.maswe_0027_vector_ignoring_hostname_verification_vuln,
        msgRes = R.string.maswe_0027_msg_ignoring_hostname_verification_vuln,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_CUSTOM_TRUST_MANAGER(
        titleRes = R.string.maswe_0027_vector_insecure_custom_trust_manager_vuln,
        msgRes = R.string.maswe_0027_msg_insecure_custom_trust_manager_vuln,
        icon = Icons.Default.BugReport
    ),
    INCORRECT_ERROR_HANDLING(
        titleRes = R.string.maswe_0027_vector_incorrect_error_handling_vuln,
        msgRes = R.string.maswe_0027_msg_incorrect_error_handling_vuln,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleRes = R.string.maswe_0027_vector_third_party_library_vuln,
        msgRes = R.string.maswe_0027_msg_third_party_library_vuln,
        icon = Icons.Default.Code
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0027",
            titleRes = R.string.maswe_0027_vuln_title,
            descRes = R.string.maswe_0027_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0027_vuln_vectors_title
        )
    }
}
