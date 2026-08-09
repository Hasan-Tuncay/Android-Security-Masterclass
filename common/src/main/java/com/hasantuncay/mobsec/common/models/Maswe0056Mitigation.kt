package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0056Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_PACKAGED_APP_INTEGRITY_VERIFICATION(
        titleSecureRes = R.string.maswe_0056_vector_no_packaged_app_integrity_verification_secure,
        msgSecureRes = R.string.maswe_0056_msg_no_packaged_app_integrity_verification_secure,
        icon = Icons.Default.Verified
    ),
    NO_SERVER_VERIFIED_APP_INTEGRITY(
        titleSecureRes = R.string.maswe_0056_vector_no_server_verified_app_integrity_secure,
        msgSecureRes = R.string.maswe_0056_msg_no_server_verified_app_integrity_secure,
        icon = Icons.Default.Dns
    ),
    MISSING_SERVER_ATTESTATION_VERIFICATION(
        titleSecureRes = R.string.maswe_0056_vector_missing_server_attestation_verification_secure,
        msgSecureRes = R.string.maswe_0056_msg_missing_server_attestation_verification_secure,
        icon = Icons.Default.Storage
    ),
    OUTDATED_SIGNING_SCHEMES(
        titleSecureRes = R.string.maswe_0056_vector_outdated_signing_schemes_secure,
        msgSecureRes = R.string.maswe_0056_msg_outdated_signing_schemes_secure,
        icon = Icons.Default.History
    );

    override val masweId = "MASWE-0056"
    override val screenTitleSecureRes = R.string.maswe_0056_secure_title
    override val screenDescSecureRes = R.string.maswe_0056_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0056_secure_vectors_title
}
