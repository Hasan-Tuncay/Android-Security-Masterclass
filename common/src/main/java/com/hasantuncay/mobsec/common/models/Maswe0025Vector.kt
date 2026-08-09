package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0025Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_TRUSTED_CONFIRMATION_PATH(
        titleVulnRes = R.string.maswe_0025_vector_no_trusted_confirmation_path_vuln,
        msgVulnRes = R.string.maswe_0025_msg_no_trusted_confirmation_path_vuln,
        icon = Icons.Default.Warning
    ),
    NO_CRYPTOGRAPHIC_EVIDENCE(
        titleVulnRes = R.string.maswe_0025_vector_no_cryptographic_evidence_vuln,
        msgVulnRes = R.string.maswe_0025_msg_no_cryptographic_evidence_vuln,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0025"
    override val screenTitleVulnRes = R.string.maswe_0025_vuln_title
    override val screenDescVulnRes = R.string.maswe_0025_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0025_vuln_vectors_title
}
