package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0041Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    LOW_MIN_VERSION_MODERN_ASSUMPTIONS(
        titleVulnRes = R.string.maswe_0041_vector_low_min_version_modern_assumptions_vuln,
        msgVulnRes = R.string.maswe_0041_msg_low_min_version_modern_assumptions_vuln,
        icon = Icons.Default.DeviceUnknown
    ),
    KNOWN_VULNERABLE_PLATFORM_SUPPORTED(
        titleVulnRes = R.string.maswe_0041_vector_known_vulnerable_platform_supported_vuln,
        msgVulnRes = R.string.maswe_0041_msg_known_vulnerable_platform_supported_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0041"
    override val screenTitleVulnRes = R.string.maswe_0041_vuln_title
    override val screenDescVulnRes = R.string.maswe_0041_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0041_vuln_vectors_title
}
