package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0021Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DEVICE_CREDENTIAL_FOR_SENSITIVE(
        titleVulnRes = R.string.maswe_0021_vector_device_credential_for_sensitive_vuln,
        msgVulnRes = R.string.maswe_0021_msg_device_credential_for_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    GENERIC_AUTH_POLICY(
        titleVulnRes = R.string.maswe_0021_vector_generic_auth_policy_vuln,
        msgVulnRes = R.string.maswe_0021_msg_generic_auth_policy_vuln,
        icon = Icons.Default.Lock
    ),
    NOT_BOUND_TO_BIOMETRIC_KEY(
        titleVulnRes = R.string.maswe_0021_vector_not_bound_to_biometric_key_vuln,
        msgVulnRes = R.string.maswe_0021_msg_not_bound_to_biometric_key_vuln,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0021"
    override val screenTitleVulnRes = R.string.maswe_0021_vuln_title
    override val screenDescVulnRes = R.string.maswe_0021_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0021_vuln_vectors_title
}
