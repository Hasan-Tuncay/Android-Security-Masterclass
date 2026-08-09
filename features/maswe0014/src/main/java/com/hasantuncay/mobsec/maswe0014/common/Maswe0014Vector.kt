package com.hasantuncay.mobsec.maswe0014.common

import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Vector
import com.hasantuncay.mobsec.maswe0014.common.Maswe0014Mitigation
import com.hasantuncay.mobsec.maswe0014.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0014: Improper Cryptographic Key Derivation
 * Modes of Introduction from MASWE repo:
 * - Plain Hash Instead Of KDF: Using MD5/SHA hashes for password key derivation
 * - Insufficient Work Factor: PBKDF2/Argon2 iteration count too low
 * - Missing Or Predictable Salt: Omitting salt or using hardcoded salt
 * - Low Entropy Input: Deriving keys directly from short PINs or low-entropy secrets without stretching
 */
enum class Maswe0014Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    PLAIN_HASH_INSTEAD_OF_KDF(
        titleRes = R.string.maswe_0014_vector_plain_hash_instead_of_kdf_vuln,
        msgRes = R.string.maswe_0014_msg_plain_hash_instead_of_kdf_vuln,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_WORK_FACTOR(
        titleRes = R.string.maswe_0014_vector_insufficient_work_factor_vuln,
        msgRes = R.string.maswe_0014_msg_insufficient_work_factor_vuln,
        icon = Icons.Default.Warning
    ),
    MISSING_OR_PREDICTABLE_SALT(
        titleRes = R.string.maswe_0014_vector_missing_or_predictable_salt_vuln,
        msgRes = R.string.maswe_0014_msg_missing_or_predictable_salt_vuln,
        icon = Icons.Default.Key
    ),
    LOW_ENTROPY_INPUT(
        titleRes = R.string.maswe_0014_vector_low_entropy_input_vuln,
        msgRes = R.string.maswe_0014_msg_low_entropy_input_vuln,
        icon = Icons.Default.NoEncryption
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0014",
            titleRes = CommonR.string.maswe_0014_vuln_title,
            descRes = CommonR.string.maswe_0014_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0014_vuln_vectors_title
        )
    }
}
