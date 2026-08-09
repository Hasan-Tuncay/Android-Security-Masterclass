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
enum class Maswe0013Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INSUFFICIENT_ENTROPY(
        titleVulnRes = R.string.maswe_0013_vector_insufficient_entropy_vuln,
        msgVulnRes = R.string.maswe_0013_msg_insufficient_entropy_vuln,
        icon = Icons.Default.Shuffle
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleVulnRes = R.string.maswe_0013_vector_insufficient_key_length_vuln,
        msgVulnRes = R.string.maswe_0013_msg_insufficient_key_length_vuln,
        icon = Icons.Default.Key
    ),
    BROKEN_KEY_ALGORITHM(
        titleVulnRes = R.string.maswe_0013_vector_broken_key_algorithm_vuln,
        msgVulnRes = R.string.maswe_0013_msg_broken_key_algorithm_vuln,
        icon = Icons.Default.Block
    ),
    INSECURE_KEY_EXPORT(
        titleVulnRes = R.string.maswe_0013_vector_insecure_key_export_vuln,
        msgVulnRes = R.string.maswe_0013_msg_insecure_key_export_vuln,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_KEY_PROPERTIES(
        titleVulnRes = R.string.maswe_0013_vector_insecure_key_properties_vuln,
        msgVulnRes = R.string.maswe_0013_msg_insecure_key_properties_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0013"
    override val screenTitleVulnRes = R.string.maswe_0013_vuln_title
    override val screenDescVulnRes = R.string.maswe_0013_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0013_vuln_vectors_title
}
