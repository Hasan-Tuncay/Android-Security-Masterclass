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
enum class Maswe0014Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    PLAIN_HASH_INSTEAD_OF_KDF(
        titleVulnRes = R.string.maswe_0014_vector_plain_hash_instead_of_kdf_vuln,
        msgVulnRes = R.string.maswe_0014_msg_plain_hash_instead_of_kdf_vuln,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_WORK_FACTOR(
        titleVulnRes = R.string.maswe_0014_vector_insufficient_work_factor_vuln,
        msgVulnRes = R.string.maswe_0014_msg_insufficient_work_factor_vuln,
        icon = Icons.Default.Warning
    ),
    MISSING_OR_PREDICTABLE_SALT(
        titleVulnRes = R.string.maswe_0014_vector_missing_or_predictable_salt_vuln,
        msgVulnRes = R.string.maswe_0014_msg_missing_or_predictable_salt_vuln,
        icon = Icons.Default.Key
    ),
    LOW_ENTROPY_INPUT(
        titleVulnRes = R.string.maswe_0014_vector_low_entropy_input_vuln,
        msgVulnRes = R.string.maswe_0014_msg_low_entropy_input_vuln,
        icon = Icons.Default.NoEncryption
    );

    override val masweId = "MASWE-0014"
    override val screenTitleVulnRes = R.string.maswe_0014_vuln_title
    override val screenDescVulnRes = R.string.maswe_0014_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0014_vuln_vectors_title
}
