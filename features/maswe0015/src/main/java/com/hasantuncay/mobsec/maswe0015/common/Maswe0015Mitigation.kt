package com.hasantuncay.mobsec.maswe0015.common

import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Vector
import com.hasantuncay.mobsec.maswe0015.common.Maswe0015Mitigation
import com.hasantuncay.mobsec.maswe0015.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0015: Cryptographic Key Rotation Not Implemented
 * Modes of Introduction from MASWE repo:
 * - No Rotation Mechanism: Single static key used indefinitely without versioning
 * - Unbounded Cryptoperiod: No key validity period or expiration policy defined
 * - Superseded Keys Not Retired: Compromised or outdated keys remain valid for new cryptographic operations
 */
enum class Maswe0015Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_ROTATION_MECHANISM(
        titleRes = R.string.maswe_0015_vector_no_rotation_mechanism_secure,
        msgRes = R.string.maswe_0015_msg_no_rotation_mechanism_secure,
        icon = Icons.Default.Lock
    ),
    UNBOUNDED_CRYPTOPERIOD(
        titleRes = R.string.maswe_0015_vector_unbounded_cryptoperiod_secure,
        msgRes = R.string.maswe_0015_msg_unbounded_cryptoperiod_secure,
        icon = Icons.Default.Warning
    ),
    SUPERSEDED_KEYS_NOT_RETIRED(
        titleRes = R.string.maswe_0015_vector_superseded_keys_not_retired_secure,
        msgRes = R.string.maswe_0015_msg_superseded_keys_not_retired_secure,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0015",
            titleRes = CommonR.string.maswe_0015_secure_title,
            descRes = CommonR.string.maswe_0015_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0015_secure_vectors_title
        )
    }
}
