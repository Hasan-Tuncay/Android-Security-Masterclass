package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0041Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    LOW_MIN_VERSION_MODERN_ASSUMPTIONS(
        titleSecureRes = R.string.maswe_0041_vector_low_min_version_modern_assumptions_secure,
        msgSecureRes = R.string.maswe_0041_msg_low_min_version_modern_assumptions_secure,
        icon = Icons.Default.DeviceUnknown
    ),
    KNOWN_VULNERABLE_PLATFORM_SUPPORTED(
        titleSecureRes = R.string.maswe_0041_vector_known_vulnerable_platform_supported_secure,
        msgSecureRes = R.string.maswe_0041_msg_known_vulnerable_platform_supported_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0041"
    override val screenTitleSecureRes = R.string.maswe_0041_secure_title
    override val screenDescSecureRes = R.string.maswe_0041_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0041_secure_vectors_title
}
