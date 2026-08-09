package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0021Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DEVICE_CREDENTIAL_FOR_SENSITIVE(
        titleRes = R.string.maswe_0021_vector_device_credential_for_sensitive_vuln,
        msgRes = R.string.maswe_0021_msg_device_credential_for_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    GENERIC_AUTH_POLICY(
        titleRes = R.string.maswe_0021_vector_generic_auth_policy_vuln,
        msgRes = R.string.maswe_0021_msg_generic_auth_policy_vuln,
        icon = Icons.Default.Lock
    ),
    NOT_BOUND_TO_BIOMETRIC_KEY(
        titleRes = R.string.maswe_0021_vector_not_bound_to_biometric_key_vuln,
        msgRes = R.string.maswe_0021_msg_not_bound_to_biometric_key_vuln,
        icon = Icons.Default.NoEncryption
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0021",
            titleRes = R.string.maswe_0021_vuln_title,
            descRes = R.string.maswe_0021_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0021_vuln_vectors_title
        )
    }
}
