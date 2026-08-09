package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0020Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    EVENT_BOUND_BIOMETRIC(
        titleVulnRes = R.string.maswe_0020_vector_event_bound_biometric_vuln,
        msgVulnRes = R.string.maswe_0020_msg_event_bound_biometric_vuln,
        icon = Icons.Default.Fingerprint
    ),
    WEAK_KEYCHAIN_FLAGS(
        titleVulnRes = R.string.maswe_0020_vector_weak_keychain_flags_vuln,
        msgVulnRes = R.string.maswe_0020_msg_weak_keychain_flags_vuln,
        icon = Icons.Default.Warning
    ),
    INSECURE_CREDENTIAL_FALLBACK(
        titleVulnRes = R.string.maswe_0020_vector_insecure_credential_fallback_vuln,
        msgVulnRes = R.string.maswe_0020_msg_insecure_credential_fallback_vuln,
        icon = Icons.Default.Lock
    ),
    LOCAL_ONLY_ENFORCEMENT(
        titleVulnRes = R.string.maswe_0020_vector_local_only_enforcement_vuln,
        msgVulnRes = R.string.maswe_0020_msg_local_only_enforcement_vuln,
        icon = Icons.Default.NoEncryption
    ),
    NO_BRUTE_FORCE_RESISTANCE(
        titleVulnRes = R.string.maswe_0020_vector_no_brute_force_resistance_vuln,
        msgVulnRes = R.string.maswe_0020_msg_no_brute_force_resistance_vuln,
        icon = Icons.Default.BugReport
    ),
    HARDCODED_CUSTOM_CREDENTIALS(
        titleVulnRes = R.string.maswe_0020_vector_hardcoded_custom_credentials_vuln,
        msgVulnRes = R.string.maswe_0020_msg_hardcoded_custom_credentials_vuln,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0020"
    override val screenTitleVulnRes = R.string.maswe_0020_vuln_title
    override val screenDescVulnRes = R.string.maswe_0020_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0020_vuln_vectors_title
}
