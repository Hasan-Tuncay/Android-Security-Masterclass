package com.hasantuncay.mobsec.maswe0009.common

import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Vector
import com.hasantuncay.mobsec.maswe0009.common.Maswe0009Mitigation
import com.hasantuncay.mobsec.maswe0009.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0009: Improper Use of MAC
 * Modes of Introduction from MASWE repo:
 * - Non-Cryptographic Checksum: Using CRC-32 or non-crypto hash where MAC is required
 * - Weak Hash-Based MAC: Using MD5 or SHA-1 in MAC construction
 * - Weak Or Reused MAC Key: Insufficient key entropy or key reuse
 * - Fragile Construction: CBC-MAC on variable-length messages, or unsafe MAC-then-encrypt
 * - Truncated Tag: Auth tags truncated below minimum security length
 * - Missing Replay Protection: MAC without nonce or timestamp
 */
enum class Maswe0009Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NON_CRYPTOGRAPHIC_CHECKSUM(
        titleRes = R.string.maswe_0009_vector_non_cryptographic_checksum_vuln,
        msgRes = R.string.maswe_0009_msg_non_cryptographic_checksum_vuln,
        icon = Icons.Default.Warning
    ),
    WEAK_HASH_BASED_MAC(
        titleRes = R.string.maswe_0009_vector_weak_hash_based_mac_vuln,
        msgRes = R.string.maswe_0009_msg_weak_hash_based_mac_vuln,
        icon = Icons.Default.Block
    ),
    WEAK_OR_REUSED_MAC_KEY(
        titleRes = R.string.maswe_0009_vector_weak_or_reused_mac_key_vuln,
        msgRes = R.string.maswe_0009_msg_weak_or_reused_mac_key_vuln,
        icon = Icons.Default.Key
    ),
    FRAGILE_CONSTRUCTION(
        titleRes = R.string.maswe_0009_vector_fragile_construction_vuln,
        msgRes = R.string.maswe_0009_msg_fragile_construction_vuln,
        icon = Icons.Default.Construction
    ),
    TRUNCATED_TAG(
        titleRes = R.string.maswe_0009_vector_truncated_tag_vuln,
        msgRes = R.string.maswe_0009_msg_truncated_tag_vuln,
        icon = Icons.Default.NoEncryption
    ),
    MISSING_REPLAY_PROTECTION(
        titleRes = R.string.maswe_0009_vector_missing_replay_protection_vuln,
        msgRes = R.string.maswe_0009_msg_missing_replay_protection_vuln,
        icon = Icons.Default.Refresh
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0009",
            titleRes = CommonR.string.maswe_0009_vuln_title,
            descRes = CommonR.string.maswe_0009_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0009_vuln_vectors_title
        )
    }
}
