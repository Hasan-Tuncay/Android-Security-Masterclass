package com.hasantuncay.mobsec.maswe0012.common

import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Vector
import com.hasantuncay.mobsec.maswe0012.common.Maswe0012Mitigation
import com.hasantuncay.mobsec.maswe0012.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0012: Improper Random Number Generation
 * Modes of Introduction from MASWE repo:
 * - Risky Random API: Using java.util.Random or non-CSPRNG in security contexts
 * - Non-Random Source: Deriving random values from timestamps or predictable sources
 * - Hardcoded Seed: Seeding PRNG with fixed or deterministic values in production
 */
enum class Maswe0012Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RISKY_RANDOM_API(
        titleRes = R.string.maswe_0012_vector_risky_random_api_secure,
        msgRes = R.string.maswe_0012_msg_risky_random_api_secure,
        icon = Icons.Default.Shuffle
    ),
    NON_RANDOM_SOURCE(
        titleRes = R.string.maswe_0012_vector_non_random_source_secure,
        msgRes = R.string.maswe_0012_msg_non_random_source_secure,
        icon = Icons.Default.Warning
    ),
    HARDCODED_SEED(
        titleRes = R.string.maswe_0012_vector_hardcoded_seed_secure,
        msgRes = R.string.maswe_0012_msg_hardcoded_seed_secure,
        icon = Icons.Default.Key
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0012",
            titleRes = CommonR.string.maswe_0012_secure_title,
            descRes = CommonR.string.maswe_0012_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0012_secure_vectors_title
        )
    }
}
