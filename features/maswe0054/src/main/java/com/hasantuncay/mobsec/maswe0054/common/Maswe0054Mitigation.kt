package com.hasantuncay.mobsec.maswe0054.common

import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Vector
import com.hasantuncay.mobsec.maswe0054.common.Maswe0054Mitigation
import com.hasantuncay.mobsec.maswe0054.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0054Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_ATTESTATION_INTEGRATED(
        titleRes = R.string.maswe_0054_vector_no_attestation_integrated_secure,
        msgRes = R.string.maswe_0054_msg_no_attestation_integrated_secure,
        icon = Icons.Default.VerifiedUser
    ),
    CLIENT_SIDE_ONLY_VERIFICATION(
        titleRes = R.string.maswe_0054_vector_client_side_only_verification_secure,
        msgRes = R.string.maswe_0054_msg_client_side_only_verification_secure,
        icon = Icons.Default.MobileOff
    ),
    MISSING_FRESHNESS_GUARANTEES(
        titleRes = R.string.maswe_0054_vector_missing_freshness_guarantees_secure,
        msgRes = R.string.maswe_0054_msg_missing_freshness_guarantees_secure,
        icon = Icons.Default.UpdateDisabled
    ),
    VERDICTS_NOT_ENFORCED(
        titleRes = R.string.maswe_0054_vector_verdicts_not_enforced_secure,
        msgRes = R.string.maswe_0054_msg_verdicts_not_enforced_secure,
        icon = Icons.Default.Warning
    ),
    INCOMPLETE_EVIDENCE_VALIDATION(
        titleRes = R.string.maswe_0054_vector_incomplete_evidence_validation_secure,
        msgRes = R.string.maswe_0054_msg_incomplete_evidence_validation_secure,
        icon = Icons.Default.CheckCircleOutline
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0054",
            titleRes = CommonR.string.maswe_0054_secure_title,
            descRes = CommonR.string.maswe_0054_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0054_secure_vectors_title
        )
    }
}
