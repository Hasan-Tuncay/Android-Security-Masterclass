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
enum class Maswe0017Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_SECURE_LOCK_CHECK(
        titleSecureRes = R.string.maswe_0017_vector_no_secure_lock_check_secure,
        msgSecureRes = R.string.maswe_0017_msg_no_secure_lock_check_secure,
        icon = Icons.Default.NoEncryption
    ),
    DATA_NOT_TIED_TO_PASSCODE(
        titleSecureRes = R.string.maswe_0017_vector_data_not_tied_to_passcode_secure,
        msgSecureRes = R.string.maswe_0017_msg_data_not_tied_to_passcode_secure,
        icon = Icons.Default.Lock
    ),
    STALE_LOCK_ASSUMPTION(
        titleSecureRes = R.string.maswe_0017_vector_stale_lock_assumption_secure,
        msgSecureRes = R.string.maswe_0017_msg_stale_lock_assumption_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0017"
    override val screenTitleSecureRes = R.string.maswe_0017_secure_title
    override val screenDescSecureRes = R.string.maswe_0017_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0017_secure_vectors_title
}
