package com.hasantuncay.mobsec.maswe0027.common

import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Vector
import com.hasantuncay.mobsec.maswe0027.common.Maswe0027Mitigation
import com.hasantuncay.mobsec.maswe0027.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0027: Insecure Certificate Validation
 */
enum class Maswe0027Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DISABLING_CERT_VALIDATION(
        titleRes = R.string.maswe_0027_vector_disabling_cert_validation_secure,
        msgRes = R.string.maswe_0027_msg_disabling_cert_validation_secure,
        icon = Icons.Default.Block
    ),
    ACCEPTING_SELF_SIGNED_CERTS(
        titleRes = R.string.maswe_0027_vector_accepting_self_signed_certs_secure,
        msgRes = R.string.maswe_0027_msg_accepting_self_signed_certs_secure,
        icon = Icons.Default.Warning
    ),
    IGNORING_HOSTNAME_VERIFICATION(
        titleRes = R.string.maswe_0027_vector_ignoring_hostname_verification_secure,
        msgRes = R.string.maswe_0027_msg_ignoring_hostname_verification_secure,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_CUSTOM_TRUST_MANAGER(
        titleRes = R.string.maswe_0027_vector_insecure_custom_trust_manager_secure,
        msgRes = R.string.maswe_0027_msg_insecure_custom_trust_manager_secure,
        icon = Icons.Default.BugReport
    ),
    INCORRECT_ERROR_HANDLING(
        titleRes = R.string.maswe_0027_vector_incorrect_error_handling_secure,
        msgRes = R.string.maswe_0027_msg_incorrect_error_handling_secure,
        icon = Icons.Default.Build
    ),
    THIRD_PARTY_LIBRARY(
        titleRes = R.string.maswe_0027_vector_third_party_library_secure,
        msgRes = R.string.maswe_0027_msg_third_party_library_secure,
        icon = Icons.Default.Code
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0027",
            titleRes = CommonR.string.maswe_0027_secure_title,
            descRes = CommonR.string.maswe_0027_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0027_secure_vectors_title
        )
    }
}
