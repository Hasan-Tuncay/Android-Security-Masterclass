package com.hasantuncay.mobsec.maswe0056.common

import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Vector
import com.hasantuncay.mobsec.maswe0056.common.Maswe0056Mitigation
import com.hasantuncay.mobsec.maswe0056.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0056Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_PACKAGED_APP_INTEGRITY_VERIFICATION(
        titleRes = R.string.maswe_0056_vector_no_packaged_app_integrity_verification_vuln,
        msgRes = R.string.maswe_0056_msg_no_packaged_app_integrity_verification_vuln,
        icon = Icons.Default.Verified
    ),
    NO_SERVER_VERIFIED_APP_INTEGRITY(
        titleRes = R.string.maswe_0056_vector_no_server_verified_app_integrity_vuln,
        msgRes = R.string.maswe_0056_msg_no_server_verified_app_integrity_vuln,
        icon = Icons.Default.Dns
    ),
    MISSING_SERVER_ATTESTATION_VERIFICATION(
        titleRes = R.string.maswe_0056_vector_missing_server_attestation_verification_vuln,
        msgRes = R.string.maswe_0056_msg_missing_server_attestation_verification_vuln,
        icon = Icons.Default.Storage
    ),
    OUTDATED_SIGNING_SCHEMES(
        titleRes = R.string.maswe_0056_vector_outdated_signing_schemes_vuln,
        msgRes = R.string.maswe_0056_msg_outdated_signing_schemes_vuln,
        icon = Icons.Default.History
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0056",
            titleRes = CommonR.string.maswe_0056_vuln_title,
            descRes = CommonR.string.maswe_0056_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0056_vuln_vectors_title
        )
    }
}
