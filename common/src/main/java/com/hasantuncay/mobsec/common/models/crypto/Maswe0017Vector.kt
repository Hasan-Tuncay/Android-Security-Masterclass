package com.hasantuncay.mobsec.common.models.crypto

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0017: Device Secure Lock Not Enforced
 * Modes of Introduction from MASWE repo:
 * - No Secure Lock Check: App does not verify KeyguardManager.isDeviceSecure before sensitive operations
 * - Data Not Tied To Passcode: Sensitive keys created without requiring device screen lock / credential
 * - Stale Lock Assumption: Lock status checked only once during setup instead of continuously at runtime
 */
enum class Maswe0017Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_SECURE_LOCK_CHECK(
        titleRes = R.string.maswe_0017_vector_no_secure_lock_check_vuln,
        msgRes = R.string.maswe_0017_msg_no_secure_lock_check_vuln,
        icon = Icons.Default.NoEncryption
    ),
    DATA_NOT_TIED_TO_PASSCODE(
        titleRes = R.string.maswe_0017_vector_data_not_tied_to_passcode_vuln,
        msgRes = R.string.maswe_0017_msg_data_not_tied_to_passcode_vuln,
        icon = Icons.Default.Lock
    ),
    STALE_LOCK_ASSUMPTION(
        titleRes = R.string.maswe_0017_vector_stale_lock_assumption_vuln,
        msgRes = R.string.maswe_0017_msg_stale_lock_assumption_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0017",
            titleRes = R.string.maswe_0017_vuln_title,
            descRes = R.string.maswe_0017_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0017_vuln_vectors_title
        )
    }
}
