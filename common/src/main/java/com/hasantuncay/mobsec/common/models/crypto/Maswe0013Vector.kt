package com.hasantuncay.mobsec.common.models.crypto

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

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
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    INSUFFICIENT_ENTROPY(
        titleRes = R.string.maswe_0013_vector_insufficient_entropy_vuln,
        msgRes = R.string.maswe_0013_msg_insufficient_entropy_vuln,
        icon = Icons.Default.Shuffle
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleRes = R.string.maswe_0013_vector_insufficient_key_length_vuln,
        msgRes = R.string.maswe_0013_msg_insufficient_key_length_vuln,
        icon = Icons.Default.Key
    ),
    BROKEN_KEY_ALGORITHM(
        titleRes = R.string.maswe_0013_vector_broken_key_algorithm_vuln,
        msgRes = R.string.maswe_0013_msg_broken_key_algorithm_vuln,
        icon = Icons.Default.Block
    ),
    INSECURE_KEY_EXPORT(
        titleRes = R.string.maswe_0013_vector_insecure_key_export_vuln,
        msgRes = R.string.maswe_0013_msg_insecure_key_export_vuln,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_KEY_PROPERTIES(
        titleRes = R.string.maswe_0013_vector_insecure_key_properties_vuln,
        msgRes = R.string.maswe_0013_msg_insecure_key_properties_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0013",
            titleRes = R.string.maswe_0013_vuln_title,
            descRes = R.string.maswe_0013_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0013_vuln_vectors_title
        )
    }
}
