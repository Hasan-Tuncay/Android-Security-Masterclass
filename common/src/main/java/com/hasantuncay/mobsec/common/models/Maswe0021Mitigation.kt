package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0021Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DEVICE_CREDENTIAL_FOR_SENSITIVE(
        titleSecureRes = R.string.maswe_0021_vector_device_credential_for_sensitive_secure,
        msgSecureRes = R.string.maswe_0021_msg_device_credential_for_sensitive_secure,
        icon = Icons.Default.Warning
    ),
    GENERIC_AUTH_POLICY(
        titleSecureRes = R.string.maswe_0021_vector_generic_auth_policy_secure,
        msgSecureRes = R.string.maswe_0021_msg_generic_auth_policy_secure,
        icon = Icons.Default.Lock
    ),
    NOT_BOUND_TO_BIOMETRIC_KEY(
        titleSecureRes = R.string.maswe_0021_vector_not_bound_to_biometric_key_secure,
        msgSecureRes = R.string.maswe_0021_msg_not_bound_to_biometric_key_secure,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0021"
    override val screenTitleSecureRes = R.string.maswe_0021_secure_title
    override val screenDescSecureRes = R.string.maswe_0021_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0021_secure_vectors_title
}
