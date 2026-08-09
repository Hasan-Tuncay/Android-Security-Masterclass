package com.hasantuncay.mobsec.common.models.auth

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0020Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    EVENT_BOUND_BIOMETRIC(
        titleRes = R.string.maswe_0020_vector_event_bound_biometric_vuln,
        msgRes = R.string.maswe_0020_msg_event_bound_biometric_vuln,
        icon = Icons.Default.Fingerprint
    ),
    WEAK_KEYCHAIN_FLAGS(
        titleRes = R.string.maswe_0020_vector_weak_keychain_flags_vuln,
        msgRes = R.string.maswe_0020_msg_weak_keychain_flags_vuln,
        icon = Icons.Default.Warning
    ),
    INSECURE_CREDENTIAL_FALLBACK(
        titleRes = R.string.maswe_0020_vector_insecure_credential_fallback_vuln,
        msgRes = R.string.maswe_0020_msg_insecure_credential_fallback_vuln,
        icon = Icons.Default.Lock
    ),
    LOCAL_ONLY_ENFORCEMENT(
        titleRes = R.string.maswe_0020_vector_local_only_enforcement_vuln,
        msgRes = R.string.maswe_0020_msg_local_only_enforcement_vuln,
        icon = Icons.Default.NoEncryption
    ),
    NO_BRUTE_FORCE_RESISTANCE(
        titleRes = R.string.maswe_0020_vector_no_brute_force_resistance_vuln,
        msgRes = R.string.maswe_0020_msg_no_brute_force_resistance_vuln,
        icon = Icons.Default.BugReport
    ),
    HARDCODED_CUSTOM_CREDENTIALS(
        titleRes = R.string.maswe_0020_vector_hardcoded_custom_credentials_vuln,
        msgRes = R.string.maswe_0020_msg_hardcoded_custom_credentials_vuln,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0020",
            titleRes = R.string.maswe_0020_vuln_title,
            descRes = R.string.maswe_0020_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0020_vuln_vectors_title
        )
    }
}
