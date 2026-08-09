package com.hasantuncay.mobsec.common.models.crypto

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0012: Improper Random Number Generation
 * Modes of Introduction from MASWE repo:
 * - Risky Random API: Using java.util.Random or non-CSPRNG in security contexts
 * - Non-Random Source: Deriving random values from timestamps or predictable sources
 * - Hardcoded Seed: Seeding PRNG with fixed or deterministic values in production
 */
enum class Maswe0012Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    RISKY_RANDOM_API(
        titleRes = R.string.maswe_0012_vector_risky_random_api_vuln,
        msgRes = R.string.maswe_0012_msg_risky_random_api_vuln,
        icon = Icons.Default.Shuffle
    ),
    NON_RANDOM_SOURCE(
        titleRes = R.string.maswe_0012_vector_non_random_source_vuln,
        msgRes = R.string.maswe_0012_msg_non_random_source_vuln,
        icon = Icons.Default.Warning
    ),
    HARDCODED_SEED(
        titleRes = R.string.maswe_0012_vector_hardcoded_seed_vuln,
        msgRes = R.string.maswe_0012_msg_hardcoded_seed_vuln,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0012",
            titleRes = R.string.maswe_0012_vuln_title,
            descRes = R.string.maswe_0012_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0012_vuln_vectors_title
        )
    }
}
