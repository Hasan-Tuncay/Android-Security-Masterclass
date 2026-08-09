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
enum class Maswe0012Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    RISKY_RANDOM_API(
        titleVulnRes = R.string.maswe_0012_vector_risky_random_api_vuln,
        msgVulnRes = R.string.maswe_0012_msg_risky_random_api_vuln,
        icon = Icons.Default.Shuffle
    ),
    NON_RANDOM_SOURCE(
        titleVulnRes = R.string.maswe_0012_vector_non_random_source_vuln,
        msgVulnRes = R.string.maswe_0012_msg_non_random_source_vuln,
        icon = Icons.Default.Warning
    ),
    HARDCODED_SEED(
        titleVulnRes = R.string.maswe_0012_vector_hardcoded_seed_vuln,
        msgVulnRes = R.string.maswe_0012_msg_hardcoded_seed_vuln,
        icon = Icons.Default.Key
    );

    override val masweId = "MASWE-0012"
    override val screenTitleVulnRes = R.string.maswe_0012_vuln_title
    override val screenDescVulnRes = R.string.maswe_0012_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0012_vuln_vectors_title
}
