package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0017: Device Secure Lock Not Enforced
 * Modes of Introduction from MASWE repo:
 * - No Secure Lock Check: App does not verify KeyguardManager.isDeviceSecure before sensitive operations
 * - Data Not Tied To Passcode: Sensitive keys created without requiring device screen lock / credential
 * - Stale Lock Assumption: Lock status checked only once during setup instead of continuously at runtime
 */
enum class Maswe0017Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_SECURE_LOCK_CHECK(
        titleVulnRes = R.string.maswe_0017_vector_no_secure_lock_check_vuln,
        msgVulnRes = R.string.maswe_0017_msg_no_secure_lock_check_vuln,
        icon = Icons.Default.NoEncryption
    ),
    DATA_NOT_TIED_TO_PASSCODE(
        titleVulnRes = R.string.maswe_0017_vector_data_not_tied_to_passcode_vuln,
        msgVulnRes = R.string.maswe_0017_msg_data_not_tied_to_passcode_vuln,
        icon = Icons.Default.Lock
    ),
    STALE_LOCK_ASSUMPTION(
        titleVulnRes = R.string.maswe_0017_vector_stale_lock_assumption_vuln,
        msgVulnRes = R.string.maswe_0017_msg_stale_lock_assumption_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0017"
    override val screenTitleVulnRes = R.string.maswe_0017_vuln_title
    override val screenDescVulnRes = R.string.maswe_0017_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0017_vuln_vectors_title
}
