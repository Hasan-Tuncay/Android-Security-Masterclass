package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0041Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    LOW_MIN_VERSION_MODERN_ASSUMPTIONS(
        titleRes = R.string.maswe_0041_vector_low_min_version_modern_assumptions_vuln,
        msgRes = R.string.maswe_0041_msg_low_min_version_modern_assumptions_vuln,
        icon = Icons.Default.DeviceUnknown
    ),
    KNOWN_VULNERABLE_PLATFORM_SUPPORTED(
        titleRes = R.string.maswe_0041_vector_known_vulnerable_platform_supported_vuln,
        msgRes = R.string.maswe_0041_msg_known_vulnerable_platform_supported_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0041",
            titleRes = R.string.maswe_0041_vuln_title,
            descRes = R.string.maswe_0041_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0041_vuln_vectors_title
        )
    }
}
