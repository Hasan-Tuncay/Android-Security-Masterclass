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
enum class Maswe0010Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    WEAK_SIGNATURE_ALGORITHM(
        titleVulnRes = R.string.maswe_0010_vector_weak_signature_algorithm_vuln,
        msgVulnRes = R.string.maswe_0010_msg_weak_signature_algorithm_vuln,
        icon = Icons.Default.Block
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleVulnRes = R.string.maswe_0010_vector_insufficient_key_length_vuln,
        msgVulnRes = R.string.maswe_0010_msg_insufficient_key_length_vuln,
        icon = Icons.Default.Key
    ),
    PREDICTABLE_NONCE(
        titleVulnRes = R.string.maswe_0010_vector_predictable_nonce_vuln,
        msgVulnRes = R.string.maswe_0010_msg_predictable_nonce_vuln,
        icon = Icons.Default.Shuffle
    ),
    KEY_REUSE_ACROSS_PURPOSES(
        titleVulnRes = R.string.maswe_0010_vector_key_reuse_across_purposes_vuln,
        msgVulnRes = R.string.maswe_0010_msg_key_reuse_across_purposes_vuln,
        icon = Icons.Default.Lock
    );

    override val masweId = "MASWE-0010"
    override val screenTitleVulnRes = R.string.maswe_0010_vuln_title
    override val screenDescVulnRes = R.string.maswe_0010_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0010_vuln_vectors_title
}
