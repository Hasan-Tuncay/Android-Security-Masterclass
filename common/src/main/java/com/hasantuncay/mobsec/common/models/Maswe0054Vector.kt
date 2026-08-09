package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0054Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_ATTESTATION_INTEGRATED(
        titleVulnRes = R.string.maswe_0054_vector_no_attestation_integrated_vuln,
        msgVulnRes = R.string.maswe_0054_msg_no_attestation_integrated_vuln,
        icon = Icons.Default.VerifiedUser
    ),
    CLIENT_SIDE_ONLY_VERIFICATION(
        titleVulnRes = R.string.maswe_0054_vector_client_side_only_verification_vuln,
        msgVulnRes = R.string.maswe_0054_msg_client_side_only_verification_vuln,
        icon = Icons.Default.MobileOff
    ),
    MISSING_FRESHNESS_GUARANTEES(
        titleVulnRes = R.string.maswe_0054_vector_missing_freshness_guarantees_vuln,
        msgVulnRes = R.string.maswe_0054_msg_missing_freshness_guarantees_vuln,
        icon = Icons.Default.UpdateDisabled
    ),
    VERDICTS_NOT_ENFORCED(
        titleVulnRes = R.string.maswe_0054_vector_verdicts_not_enforced_vuln,
        msgVulnRes = R.string.maswe_0054_msg_verdicts_not_enforced_vuln,
        icon = Icons.Default.Warning
    ),
    INCOMPLETE_EVIDENCE_VALIDATION(
        titleVulnRes = R.string.maswe_0054_vector_incomplete_evidence_validation_vuln,
        msgVulnRes = R.string.maswe_0054_msg_incomplete_evidence_validation_vuln,
        icon = Icons.Default.CheckCircleOutline
    );

    override val masweId = "MASWE-0054"
    override val screenTitleVulnRes = R.string.maswe_0054_vuln_title
    override val screenDescVulnRes = R.string.maswe_0054_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0054_vuln_vectors_title
}
