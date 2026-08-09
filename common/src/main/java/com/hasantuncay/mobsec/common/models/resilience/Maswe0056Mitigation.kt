package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0056Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_PACKAGED_APP_INTEGRITY_VERIFICATION(
        titleRes = R.string.maswe_0056_vector_no_packaged_app_integrity_verification_secure,
        msgRes = R.string.maswe_0056_msg_no_packaged_app_integrity_verification_secure,
        icon = Icons.Default.Verified
    ),
    NO_SERVER_VERIFIED_APP_INTEGRITY(
        titleRes = R.string.maswe_0056_vector_no_server_verified_app_integrity_secure,
        msgRes = R.string.maswe_0056_msg_no_server_verified_app_integrity_secure,
        icon = Icons.Default.Dns
    ),
    MISSING_SERVER_ATTESTATION_VERIFICATION(
        titleRes = R.string.maswe_0056_vector_missing_server_attestation_verification_secure,
        msgRes = R.string.maswe_0056_msg_missing_server_attestation_verification_secure,
        icon = Icons.Default.Storage
    ),
    OUTDATED_SIGNING_SCHEMES(
        titleRes = R.string.maswe_0056_vector_outdated_signing_schemes_secure,
        msgRes = R.string.maswe_0056_msg_outdated_signing_schemes_secure,
        icon = Icons.Default.History
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0056",
            titleRes = R.string.maswe_0056_secure_title,
            descRes = R.string.maswe_0056_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0056_secure_vectors_title
        )
    }
}
