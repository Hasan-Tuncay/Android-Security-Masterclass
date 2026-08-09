package com.hasantuncay.mobsec.maswe0038.common

import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Vector
import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Mitigation
import com.hasantuncay.mobsec.maswe0038.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0038Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISSING_PLATFORM_SCREENSHOT_PROTECTION(
        titleRes = R.string.maswe_0038_vector_missing_platform_screenshot_protection_vuln,
        msgRes = R.string.maswe_0038_msg_missing_platform_screenshot_protection_vuln,
        icon = Icons.Default.Screenshot
    ),
    MISSING_CAPTURE_STATE_REDACTION(
        titleRes = R.string.maswe_0038_vector_missing_capture_state_redaction_vuln,
        msgRes = R.string.maswe_0038_msg_missing_capture_state_redaction_vuln,
        icon = Icons.Default.Videocam
    ),
    EXCESSIVE_ON_SCREEN_DISCLOSURE(
        titleRes = R.string.maswe_0038_vector_excessive_on_screen_disclosure_vuln,
        msgRes = R.string.maswe_0038_msg_excessive_on_screen_disclosure_vuln,
        icon = Icons.Default.Visibility
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0038",
            titleRes = CommonR.string.maswe_0038_vuln_title,
            descRes = CommonR.string.maswe_0038_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0038_vuln_vectors_title
        )
    }
}
