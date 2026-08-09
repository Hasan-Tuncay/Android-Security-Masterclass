package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0054Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_ATTESTATION_INTEGRATED(
        titleSecureRes = R.string.maswe_0054_vector_no_attestation_integrated_secure,
        msgSecureRes = R.string.maswe_0054_msg_no_attestation_integrated_secure,
        icon = Icons.Default.VerifiedUser
    ),
    CLIENT_SIDE_ONLY_VERIFICATION(
        titleSecureRes = R.string.maswe_0054_vector_client_side_only_verification_secure,
        msgSecureRes = R.string.maswe_0054_msg_client_side_only_verification_secure,
        icon = Icons.Default.MobileOff
    ),
    MISSING_FRESHNESS_GUARANTEES(
        titleSecureRes = R.string.maswe_0054_vector_missing_freshness_guarantees_secure,
        msgSecureRes = R.string.maswe_0054_msg_missing_freshness_guarantees_secure,
        icon = Icons.Default.UpdateDisabled
    ),
    VERDICTS_NOT_ENFORCED(
        titleSecureRes = R.string.maswe_0054_vector_verdicts_not_enforced_secure,
        msgSecureRes = R.string.maswe_0054_msg_verdicts_not_enforced_secure,
        icon = Icons.Default.Warning
    ),
    INCOMPLETE_EVIDENCE_VALIDATION(
        titleSecureRes = R.string.maswe_0054_vector_incomplete_evidence_validation_secure,
        msgSecureRes = R.string.maswe_0054_msg_incomplete_evidence_validation_secure,
        icon = Icons.Default.CheckCircleOutline
    );

    override val masweId = "MASWE-0054"
    override val screenTitleSecureRes = R.string.maswe_0054_secure_title
    override val screenDescSecureRes = R.string.maswe_0054_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0054_secure_vectors_title
}
