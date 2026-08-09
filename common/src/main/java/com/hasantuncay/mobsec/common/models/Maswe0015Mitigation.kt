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
enum class Maswe0015Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_ROTATION_MECHANISM(
        titleSecureRes = R.string.maswe_0015_vector_no_rotation_mechanism_secure,
        msgSecureRes = R.string.maswe_0015_msg_no_rotation_mechanism_secure,
        icon = Icons.Default.Lock
    ),
    UNBOUNDED_CRYPTOPERIOD(
        titleSecureRes = R.string.maswe_0015_vector_unbounded_cryptoperiod_secure,
        msgSecureRes = R.string.maswe_0015_msg_unbounded_cryptoperiod_secure,
        icon = Icons.Default.Warning
    ),
    SUPERSEDED_KEYS_NOT_RETIRED(
        titleSecureRes = R.string.maswe_0015_vector_superseded_keys_not_retired_secure,
        msgSecureRes = R.string.maswe_0015_msg_superseded_keys_not_retired_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0015"
    override val screenTitleSecureRes = R.string.maswe_0015_secure_title
    override val screenDescSecureRes = R.string.maswe_0015_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0015_secure_vectors_title
}
