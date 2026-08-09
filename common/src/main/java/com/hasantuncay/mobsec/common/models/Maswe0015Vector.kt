package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0015: Cryptographic Key Rotation Not Implemented
 * Modes of Introduction from MASWE repo:
 * - No Rotation Mechanism: Single static key used indefinitely without versioning
 * - Unbounded Cryptoperiod: No key validity period or expiration policy defined
 * - Superseded Keys Not Retired: Compromised or outdated keys remain valid for new cryptographic operations
 */
enum class Maswe0015Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_ROTATION_MECHANISM(
        titleVulnRes = R.string.maswe_0015_vector_no_rotation_mechanism_vuln,
        msgVulnRes = R.string.maswe_0015_msg_no_rotation_mechanism_vuln,
        icon = Icons.Default.Lock
    ),
    UNBOUNDED_CRYPTOPERIOD(
        titleVulnRes = R.string.maswe_0015_vector_unbounded_cryptoperiod_vuln,
        msgVulnRes = R.string.maswe_0015_msg_unbounded_cryptoperiod_vuln,
        icon = Icons.Default.Warning
    ),
    SUPERSEDED_KEYS_NOT_RETIRED(
        titleVulnRes = R.string.maswe_0015_vector_superseded_keys_not_retired_vuln,
        msgVulnRes = R.string.maswe_0015_msg_superseded_keys_not_retired_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0015"
    override val screenTitleVulnRes = R.string.maswe_0015_vuln_title
    override val screenDescVulnRes = R.string.maswe_0015_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0015_vuln_vectors_title
}
