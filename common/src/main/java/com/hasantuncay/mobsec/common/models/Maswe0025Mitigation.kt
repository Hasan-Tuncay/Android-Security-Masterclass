package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0025Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_TRUSTED_CONFIRMATION_PATH(
        titleSecureRes = R.string.maswe_0025_vector_no_trusted_confirmation_path_secure,
        msgSecureRes = R.string.maswe_0025_msg_no_trusted_confirmation_path_secure,
        icon = Icons.Default.Warning
    ),
    NO_CRYPTOGRAPHIC_EVIDENCE(
        titleSecureRes = R.string.maswe_0025_vector_no_cryptographic_evidence_secure,
        msgSecureRes = R.string.maswe_0025_msg_no_cryptographic_evidence_secure,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0025"
    override val screenTitleSecureRes = R.string.maswe_0025_secure_title
    override val screenDescSecureRes = R.string.maswe_0025_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0025_secure_vectors_title
}
