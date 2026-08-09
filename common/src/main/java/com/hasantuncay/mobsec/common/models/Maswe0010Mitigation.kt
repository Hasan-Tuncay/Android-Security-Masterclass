package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0010: Improper Generation of Cryptographic Signatures
 * Modes of Introduction from MASWE repo:
 * - Weak Signature Algorithm: Using SHA1withRSA or deprecated algorithms
 * - Insufficient Key Length: Using short signature keys
 * - Predictable Nonce: ECDSA nonce reuse or predictable random values
 * - Key Reuse Across Purposes: Using the same key for signing and encryption
 */
enum class Maswe0010Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    WEAK_SIGNATURE_ALGORITHM(
        titleSecureRes = R.string.maswe_0010_vector_weak_signature_algorithm_secure,
        msgSecureRes = R.string.maswe_0010_msg_weak_signature_algorithm_secure,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleSecureRes = R.string.maswe_0010_vector_insufficient_key_length_secure,
        msgSecureRes = R.string.maswe_0010_msg_insufficient_key_length_secure,
        icon = Icons.Default.Key
    ),
    PREDICTABLE_NONCE(
        titleSecureRes = R.string.maswe_0010_vector_predictable_nonce_secure,
        msgSecureRes = R.string.maswe_0010_msg_predictable_nonce_secure,
        icon = Icons.Default.Shuffle
    ),
    KEY_REUSE_ACROSS_PURPOSES(
        titleSecureRes = R.string.maswe_0010_vector_key_reuse_across_purposes_secure,
        msgSecureRes = R.string.maswe_0010_msg_key_reuse_across_purposes_secure,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0010"
    override val screenTitleSecureRes = R.string.maswe_0010_secure_title
    override val screenDescSecureRes = R.string.maswe_0010_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0010_secure_vectors_title
}
