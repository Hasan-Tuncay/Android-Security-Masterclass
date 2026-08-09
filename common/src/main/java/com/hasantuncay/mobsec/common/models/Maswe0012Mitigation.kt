package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0012: Improper Random Number Generation
 * Modes of Introduction from MASWE repo:
 * - Risky Random API: Using java.util.Random or non-CSPRNG in security contexts
 * - Non-Random Source: Deriving random values from timestamps or predictable sources
 * - Hardcoded Seed: Seeding PRNG with fixed or deterministic values in production
 */
enum class Maswe0012Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RISKY_RANDOM_API(
        titleSecureRes = R.string.maswe_0012_vector_risky_random_api_secure,
        msgSecureRes = R.string.maswe_0012_msg_risky_random_api_secure,
        icon = Icons.Default.Shuffle
    ),
    NON_RANDOM_SOURCE(
        titleSecureRes = R.string.maswe_0012_vector_non_random_source_secure,
        msgSecureRes = R.string.maswe_0012_msg_non_random_source_secure,
        icon = Icons.Default.Warning
    ),
    HARDCODED_SEED(
        titleSecureRes = R.string.maswe_0012_vector_hardcoded_seed_secure,
        msgSecureRes = R.string.maswe_0012_msg_hardcoded_seed_secure,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0012"
    override val screenTitleSecureRes = R.string.maswe_0012_secure_title
    override val screenDescSecureRes = R.string.maswe_0012_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0012_secure_vectors_title
}
