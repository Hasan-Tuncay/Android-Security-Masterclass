package com.hasantuncay.mobsec.common.models.crypto

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0016: Cryptographic Key Access Not Restricted
 * Modes of Introduction from MASWE repo:
 * - No User Auth Requirement: Key usable without biometric or passcode authentication
 * - Usable While Locked: Key accessible when the device is locked
 * - Not Device Bound: Key exported or migrated via backup tools
 * - Unbounded Auth Validity: Biometric authentication validity window set too long or indefinite
 * - Hardware Without Restriction: StrongBox / TEE key created without access control policy
 */
enum class Maswe0016Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_USER_AUTH_REQUIREMENT(
        titleRes = R.string.maswe_0016_vector_no_user_auth_requirement_vuln,
        msgRes = R.string.maswe_0016_msg_no_user_auth_requirement_vuln,
        icon = Icons.Default.NoEncryption
    ),
    USABLE_WHILE_LOCKED(
        titleRes = R.string.maswe_0016_vector_usable_while_locked_vuln,
        msgRes = R.string.maswe_0016_msg_usable_while_locked_vuln,
        icon = Icons.Default.Lock
    ),
    NOT_DEVICE_BOUND(
        titleRes = R.string.maswe_0016_vector_not_device_bound_vuln,
        msgRes = R.string.maswe_0016_msg_not_device_bound_vuln,
        icon = Icons.Default.Warning
    ),
    UNBOUNDED_AUTH_VALIDITY(
        titleRes = R.string.maswe_0016_vector_unbounded_auth_validity_vuln,
        msgRes = R.string.maswe_0016_msg_unbounded_auth_validity_vuln,
        icon = Icons.Default.Key
    ),
    HARDWARE_WITHOUT_RESTRICTION(
        titleRes = R.string.maswe_0016_vector_hardware_without_restriction_vuln,
        msgRes = R.string.maswe_0016_msg_hardware_without_restriction_vuln,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0016",
            titleRes = R.string.maswe_0016_vuln_title,
            descRes = R.string.maswe_0016_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0016_vuln_vectors_title
        )
    }
}
