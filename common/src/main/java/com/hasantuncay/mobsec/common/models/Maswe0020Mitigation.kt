package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0020Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    EVENT_BOUND_BIOMETRIC(
        titleSecureRes = R.string.maswe_0020_vector_event_bound_biometric_secure,
        msgSecureRes = R.string.maswe_0020_msg_event_bound_biometric_secure,
        icon = Icons.Default.Fingerprint
    ),
    WEAK_KEYCHAIN_FLAGS(
        titleSecureRes = R.string.maswe_0020_vector_weak_keychain_flags_secure,
        msgSecureRes = R.string.maswe_0020_msg_weak_keychain_flags_secure,
        icon = Icons.Default.Warning
    ),
    INSECURE_CREDENTIAL_FALLBACK(
        titleSecureRes = R.string.maswe_0020_vector_insecure_credential_fallback_secure,
        msgSecureRes = R.string.maswe_0020_msg_insecure_credential_fallback_secure,
        icon = Icons.Default.Lock
    ),
    LOCAL_ONLY_ENFORCEMENT(
        titleSecureRes = R.string.maswe_0020_vector_local_only_enforcement_secure,
        msgSecureRes = R.string.maswe_0020_msg_local_only_enforcement_secure,
        icon = Icons.Default.NoEncryption
    ),
    NO_BRUTE_FORCE_RESISTANCE(
        titleSecureRes = R.string.maswe_0020_vector_no_brute_force_resistance_secure,
        msgSecureRes = R.string.maswe_0020_msg_no_brute_force_resistance_secure,
        icon = Icons.Default.BugReport
    ),
    HARDCODED_CUSTOM_CREDENTIALS(
        titleSecureRes = R.string.maswe_0020_vector_hardcoded_custom_credentials_secure,
        msgSecureRes = R.string.maswe_0020_msg_hardcoded_custom_credentials_secure,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0020"
    override val screenTitleSecureRes = R.string.maswe_0020_secure_title
    override val screenDescSecureRes = R.string.maswe_0020_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0020_secure_vectors_title
}
