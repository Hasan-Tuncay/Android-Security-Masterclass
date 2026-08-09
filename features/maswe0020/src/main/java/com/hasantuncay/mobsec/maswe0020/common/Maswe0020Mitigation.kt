package com.hasantuncay.mobsec.maswe0020.common

import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Vector
import com.hasantuncay.mobsec.maswe0020.common.Maswe0020Mitigation
import com.hasantuncay.mobsec.maswe0020.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0020Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    EVENT_BOUND_BIOMETRIC(
        titleRes = R.string.maswe_0020_vector_event_bound_biometric_secure,
        msgRes = R.string.maswe_0020_msg_event_bound_biometric_secure,
        icon = Icons.Default.Fingerprint
    ),
    WEAK_KEYCHAIN_FLAGS(
        titleRes = R.string.maswe_0020_vector_weak_keychain_flags_secure,
        msgRes = R.string.maswe_0020_msg_weak_keychain_flags_secure,
        icon = Icons.Default.Warning
    ),
    INSECURE_CREDENTIAL_FALLBACK(
        titleRes = R.string.maswe_0020_vector_insecure_credential_fallback_secure,
        msgRes = R.string.maswe_0020_msg_insecure_credential_fallback_secure,
        icon = Icons.Default.Lock
    ),
    LOCAL_ONLY_ENFORCEMENT(
        titleRes = R.string.maswe_0020_vector_local_only_enforcement_secure,
        msgRes = R.string.maswe_0020_msg_local_only_enforcement_secure,
        icon = Icons.Default.NoEncryption
    ),
    NO_BRUTE_FORCE_RESISTANCE(
        titleRes = R.string.maswe_0020_vector_no_brute_force_resistance_secure,
        msgRes = R.string.maswe_0020_msg_no_brute_force_resistance_secure,
        icon = Icons.Default.BugReport
    ),
    HARDCODED_CUSTOM_CREDENTIALS(
        titleRes = R.string.maswe_0020_vector_hardcoded_custom_credentials_secure,
        msgRes = R.string.maswe_0020_msg_hardcoded_custom_credentials_secure,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0020",
            titleRes = CommonR.string.maswe_0020_secure_title,
            descRes = CommonR.string.maswe_0020_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0020_secure_vectors_title
        )
    }
}
