package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0014: Improper Cryptographic Key Derivation
 * Modes of Introduction from MASWE repo:
 * - Plain Hash Instead Of KDF: Using MD5/SHA hashes for password key derivation
 * - Insufficient Work Factor: PBKDF2/Argon2 iteration count too low
 * - Missing Or Predictable Salt: Omitting salt or using hardcoded salt
 * - Low Entropy Input: Deriving keys directly from short PINs or low-entropy secrets without stretching
 */
enum class Maswe0014Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    PLAIN_HASH_INSTEAD_OF_KDF(
        titleSecureRes = R.string.maswe_0014_vector_plain_hash_instead_of_kdf_secure,
        msgSecureRes = R.string.maswe_0014_msg_plain_hash_instead_of_kdf_secure,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_WORK_FACTOR(
        titleSecureRes = R.string.maswe_0014_vector_insufficient_work_factor_secure,
        msgSecureRes = R.string.maswe_0014_msg_insufficient_work_factor_secure,
        icon = Icons.Default.Warning
    ),
    MISSING_OR_PREDICTABLE_SALT(
        titleSecureRes = R.string.maswe_0014_vector_missing_or_predictable_salt_secure,
        msgSecureRes = R.string.maswe_0014_msg_missing_or_predictable_salt_secure,
        icon = Icons.Default.Key
    ),
    LOW_ENTROPY_INPUT(
        titleSecureRes = R.string.maswe_0014_vector_low_entropy_input_secure,
        msgSecureRes = R.string.maswe_0014_msg_low_entropy_input_secure,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0014"
    override val screenTitleSecureRes = R.string.maswe_0014_secure_title
    override val screenDescSecureRes = R.string.maswe_0014_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0014_secure_vectors_title
}
