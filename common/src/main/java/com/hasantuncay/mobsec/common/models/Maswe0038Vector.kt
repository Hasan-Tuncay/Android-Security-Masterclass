package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0038Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISSING_PLATFORM_SCREENSHOT_PROTECTION(
        titleVulnRes = R.string.maswe_0038_vector_missing_platform_screenshot_protection_vuln,
        msgVulnRes = R.string.maswe_0038_msg_missing_platform_screenshot_protection_vuln,
        icon = Icons.Default.Screenshot
    ),
    MISSING_CAPTURE_STATE_REDACTION(
        titleVulnRes = R.string.maswe_0038_vector_missing_capture_state_redaction_vuln,
        msgVulnRes = R.string.maswe_0038_msg_missing_capture_state_redaction_vuln,
        icon = Icons.Default.Videocam
    ),
    EXCESSIVE_ON_SCREEN_DISCLOSURE(
        titleVulnRes = R.string.maswe_0038_vector_excessive_on_screen_disclosure_vuln,
        msgVulnRes = R.string.maswe_0038_msg_excessive_on_screen_disclosure_vuln,
        icon = Icons.Default.Visibility
    );

    override val masweId = "MASWE-0038"
    override val screenTitleVulnRes = R.string.maswe_0038_vuln_title
    override val screenDescVulnRes = R.string.maswe_0038_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0038_vuln_vectors_title
}
