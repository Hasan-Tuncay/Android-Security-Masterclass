package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0007: Improper Encryption
 * Modes of Introduction from MASWE repo:
 * - Broken Algorithms (RC4, DES, 3DES)
 * - Predictable or Reused IVs (hardcoded, null, reused in AES-CBC/CTR)
 * - Risky Padding (PKCS#7 with unauthenticated AES-CBC, PKCS#1 v1.5 RSA)
 * - Broken Modes of Operation (AES-ECB)
 * - Insufficient Key Length
 * - Insecure or Wrong Key Usage (key reuse for multiple purposes)
 * - Non-Cryptographic Operations (XOR, Base64, obfuscation)
 */
enum class Maswe0007Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    BROKEN_ALGORITHM(
        titleSecureRes = R.string.maswe_0007_vector_broken_algo_secure,
        msgSecureRes = R.string.maswe_0007_msg_broken_algo_secure,
        icon = Icons.Default.Block
    ),
    REUSED_IV(
        titleSecureRes = R.string.maswe_0007_vector_reused_iv_secure,
        msgSecureRes = R.string.maswe_0007_msg_reused_iv_secure,
        icon = Icons.Default.Shuffle
    ),
    RISKY_PADDING(
        titleSecureRes = R.string.maswe_0007_vector_risky_padding_secure,
        msgSecureRes = R.string.maswe_0007_msg_risky_padding_secure,
        icon = Icons.Default.Warning
    ),
    ECB_MODE(
        titleSecureRes = R.string.maswe_0007_vector_ecb_mode_secure,
        msgSecureRes = R.string.maswe_0007_msg_ecb_mode_secure,
        icon = Icons.Default.NoEncryption
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleSecureRes = R.string.maswe_0007_vector_key_length_secure,
        msgSecureRes = R.string.maswe_0007_msg_key_length_secure,
        icon = Icons.Default.Key
    ),
    KEY_REUSE(
        titleSecureRes = R.string.maswe_0007_vector_key_reuse_secure,
        msgSecureRes = R.string.maswe_0007_msg_key_reuse_secure,
        icon = Icons.Default.Lock
    ),
    NON_CRYPTO_OBFUSCATION(
        titleSecureRes = R.string.maswe_0007_vector_non_crypto_secure,
        msgSecureRes = R.string.maswe_0007_msg_non_crypto_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0007"
    override val screenTitleSecureRes = R.string.maswe_0007_secure_title
    override val screenDescSecureRes = R.string.maswe_0007_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0007_secure_vectors_title
}
