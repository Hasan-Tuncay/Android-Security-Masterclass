package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0016: Cryptographic Key Access Not Restricted
 * Modes of Introduction from MASWE repo:
 * - No User Auth Requirement: Key usable without biometric or passcode authentication
 * - Usable While Locked: Key accessible when the device is locked
 * - Not Device Bound: Key exported or migrated via backup tools
 * - Unbounded Auth Validity: Biometric authentication validity window set too long or indefinite
 * - Hardware Without Restriction: StrongBox / TEE key created without access control policy
 */
enum class Maswe0016Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_USER_AUTH_REQUIREMENT(
        titleSecureRes = R.string.maswe_0016_vector_no_user_auth_requirement_secure,
        msgSecureRes = R.string.maswe_0016_msg_no_user_auth_requirement_secure,
        icon = Icons.Default.NoEncryption
    ),
    USABLE_WHILE_LOCKED(
        titleSecureRes = R.string.maswe_0016_vector_usable_while_locked_secure,
        msgSecureRes = R.string.maswe_0016_msg_usable_while_locked_secure,
        icon = Icons.Default.Lock
    ),
    NOT_DEVICE_BOUND(
        titleSecureRes = R.string.maswe_0016_vector_not_device_bound_secure,
        msgSecureRes = R.string.maswe_0016_msg_not_device_bound_secure,
        icon = Icons.Default.Warning
    ),
    UNBOUNDED_AUTH_VALIDITY(
        titleSecureRes = R.string.maswe_0016_vector_unbounded_auth_validity_secure,
        msgSecureRes = R.string.maswe_0016_msg_unbounded_auth_validity_secure,
        icon = Icons.Default.Key
    ),
    HARDWARE_WITHOUT_RESTRICTION(
        titleSecureRes = R.string.maswe_0016_vector_hardware_without_restriction_secure,
        msgSecureRes = R.string.maswe_0016_msg_hardware_without_restriction_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0016"
    override val screenTitleSecureRes = R.string.maswe_0016_secure_title
    override val screenDescSecureRes = R.string.maswe_0016_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0016_secure_vectors_title
}
