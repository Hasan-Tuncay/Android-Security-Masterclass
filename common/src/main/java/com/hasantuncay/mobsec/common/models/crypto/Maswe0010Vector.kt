package com.hasantuncay.mobsec.common.models.crypto

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0010: Improper Generation of Cryptographic Signatures
 * Modes of Introduction from MASWE repo:
 * - Weak Signature Algorithm: Using SHA1withRSA or deprecated algorithms
 * - Insufficient Key Length: Using short signature keys
 * - Predictable Nonce: ECDSA nonce reuse or predictable random values
 * - Key Reuse Across Purposes: Using the same key for signing and encryption
 */
enum class Maswe0010Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    WEAK_SIGNATURE_ALGORITHM(
        titleRes = R.string.maswe_0010_vector_weak_signature_algorithm_vuln,
        msgRes = R.string.maswe_0010_msg_weak_signature_algorithm_vuln,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleRes = R.string.maswe_0010_vector_insufficient_key_length_vuln,
        msgRes = R.string.maswe_0010_msg_insufficient_key_length_vuln,
        icon = Icons.Default.Key
    ),
    PREDICTABLE_NONCE(
        titleRes = R.string.maswe_0010_vector_predictable_nonce_vuln,
        msgRes = R.string.maswe_0010_msg_predictable_nonce_vuln,
        icon = Icons.Default.Shuffle
    ),
    KEY_REUSE_ACROSS_PURPOSES(
        titleRes = R.string.maswe_0010_vector_key_reuse_across_purposes_vuln,
        msgRes = R.string.maswe_0010_msg_key_reuse_across_purposes_vuln,
        icon = Icons.Default.Lock
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0010",
            titleRes = R.string.maswe_0010_vuln_title,
            descRes = R.string.maswe_0010_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0010_vuln_vectors_title
        )
    }
}
