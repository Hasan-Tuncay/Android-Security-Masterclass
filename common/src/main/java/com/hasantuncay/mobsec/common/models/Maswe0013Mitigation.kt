package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0013: Improper Cryptographic Key Generation
 * Modes of Introduction from MASWE repo:
 * - Insufficient Entropy: Generating keying material with insufficient entropy
 * - Insufficient Key Length: Generating keys shorter than recommended standards
 * - Broken Key Algorithm: Generating keys for broken cipher algorithms
 * - Insecure Key Export: Exporting raw key material in plaintext
 * - Insecure Key Properties: Keys created without hardware backing or with overly broad purposes
 */
enum class Maswe0013Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    INSUFFICIENT_ENTROPY(
        titleSecureRes = R.string.maswe_0013_vector_insufficient_entropy_secure,
        msgSecureRes = R.string.maswe_0013_msg_insufficient_entropy_secure,
        icon = Icons.Default.Shuffle
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleSecureRes = R.string.maswe_0013_vector_insufficient_key_length_secure,
        msgSecureRes = R.string.maswe_0013_msg_insufficient_key_length_secure,
        icon = Icons.Default.Key
    ),
    BROKEN_KEY_ALGORITHM(
        titleSecureRes = R.string.maswe_0013_vector_broken_key_algorithm_secure,
        msgSecureRes = R.string.maswe_0013_msg_broken_key_algorithm_secure,
        icon = Icons.Default.Block
    ),
    INSECURE_KEY_EXPORT(
        titleSecureRes = R.string.maswe_0013_vector_insecure_key_export_secure,
        msgSecureRes = R.string.maswe_0013_msg_insecure_key_export_secure,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_KEY_PROPERTIES(
        titleSecureRes = R.string.maswe_0013_vector_insecure_key_properties_secure,
        msgSecureRes = R.string.maswe_0013_msg_insecure_key_properties_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0013"
    override val screenTitleSecureRes = R.string.maswe_0013_secure_title
    override val screenDescSecureRes = R.string.maswe_0013_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0013_secure_vectors_title
}
