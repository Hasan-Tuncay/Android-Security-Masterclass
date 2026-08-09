package com.hasantuncay.mobsec.maswe0013.common

import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Vector
import com.hasantuncay.mobsec.maswe0013.common.Maswe0013Mitigation
import com.hasantuncay.mobsec.maswe0013.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
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
enum class Maswe0013Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    INSUFFICIENT_ENTROPY(
        titleRes = R.string.maswe_0013_vector_insufficient_entropy_secure,
        msgRes = R.string.maswe_0013_msg_insufficient_entropy_secure,
        icon = Icons.Default.Shuffle
    ),
    INSUFFICIENT_KEY_LENGTH(
        titleRes = R.string.maswe_0013_vector_insufficient_key_length_secure,
        msgRes = R.string.maswe_0013_msg_insufficient_key_length_secure,
        icon = Icons.Default.Key
    ),
    BROKEN_KEY_ALGORITHM(
        titleRes = R.string.maswe_0013_vector_broken_key_algorithm_secure,
        msgRes = R.string.maswe_0013_msg_broken_key_algorithm_secure,
        icon = Icons.Default.Block
    ),
    INSECURE_KEY_EXPORT(
        titleRes = R.string.maswe_0013_vector_insecure_key_export_secure,
        msgRes = R.string.maswe_0013_msg_insecure_key_export_secure,
        icon = Icons.Default.NoEncryption
    ),
    INSECURE_KEY_PROPERTIES(
        titleRes = R.string.maswe_0013_vector_insecure_key_properties_secure,
        msgRes = R.string.maswe_0013_msg_insecure_key_properties_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0013",
            titleRes = CommonR.string.maswe_0013_secure_title,
            descRes = CommonR.string.maswe_0013_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0013_secure_vectors_title
        )
    }
}
