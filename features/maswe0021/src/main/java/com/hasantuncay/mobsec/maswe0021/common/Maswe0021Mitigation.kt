package com.hasantuncay.mobsec.maswe0021.common

import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Vector
import com.hasantuncay.mobsec.maswe0021.common.Maswe0021Mitigation
import com.hasantuncay.mobsec.maswe0021.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0021Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DEVICE_CREDENTIAL_FOR_SENSITIVE(
        titleRes = R.string.maswe_0021_vector_device_credential_for_sensitive_secure,
        msgRes = R.string.maswe_0021_msg_device_credential_for_sensitive_secure,
        icon = Icons.Default.Warning
    ),
    GENERIC_AUTH_POLICY(
        titleRes = R.string.maswe_0021_vector_generic_auth_policy_secure,
        msgRes = R.string.maswe_0021_msg_generic_auth_policy_secure,
        icon = Icons.Default.Lock
    ),
    NOT_BOUND_TO_BIOMETRIC_KEY(
        titleRes = R.string.maswe_0021_vector_not_bound_to_biometric_key_secure,
        msgRes = R.string.maswe_0021_msg_not_bound_to_biometric_key_secure,
        icon = Icons.Default.NoEncryption
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0021",
            titleRes = CommonR.string.maswe_0021_secure_title,
            descRes = CommonR.string.maswe_0021_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0021_secure_vectors_title
        )
    }
}
