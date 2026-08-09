package com.hasantuncay.mobsec.maswe0007.common

import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Mitigation
import com.hasantuncay.mobsec.maswe0007.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

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
enum class Maswe0007Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    BROKEN_ALGORITHM(
        titleRes = R.string.maswe_0007_vector_broken_algo_vuln,
        msgRes = R.string.maswe_0007_msg_broken_algo_vuln,
        icon = Icons.Default.Block
    ),
    REUSED_IV(
        titleRes = R.string.maswe_0007_vector_reused_iv_vuln,
        msgRes = R.string.maswe_0007_msg_reused_iv_vuln,
        icon = Icons.Default.Shuffle
    ),
    RISKY_PADDING(
        titleRes = R.string.maswe_0007_vector_risky_padding_vuln,
        msgRes = R.string.maswe_0007_msg_risky_padding_vuln,
        icon = Icons.Default.Warning
    ),
    ECB_MODE(
        titleRes = R.string.maswe_0007_vector_ecb_mode_vuln,
        msgRes = R.string.maswe_0007_msg_ecb_mode_vuln,
        icon = Icons.Default.NoEncryption
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleRes = R.string.maswe_0007_vector_key_length_vuln,
        msgRes = R.string.maswe_0007_msg_key_length_vuln,
        icon = Icons.Default.Key
    ),
    KEY_REUSE(
        titleRes = R.string.maswe_0007_vector_key_reuse_vuln,
        msgRes = R.string.maswe_0007_msg_key_reuse_vuln,
        icon = Icons.Default.Lock
    ),
    NON_CRYPTO_OBFUSCATION(
        titleRes = R.string.maswe_0007_vector_non_crypto_vuln,
        msgRes = R.string.maswe_0007_msg_non_crypto_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0007",
            titleRes = CommonR.string.maswe_0007_vuln_title,
            descRes = CommonR.string.maswe_0007_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0007_vuln_vectors_title
        )
    }
}
