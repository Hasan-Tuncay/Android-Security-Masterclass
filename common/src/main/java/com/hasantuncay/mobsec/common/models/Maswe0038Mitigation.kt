package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0038Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_PLATFORM_SCREENSHOT_PROTECTION(
        titleSecureRes = R.string.maswe_0038_vector_missing_platform_screenshot_protection_secure,
        msgSecureRes = R.string.maswe_0038_msg_missing_platform_screenshot_protection_secure,
        icon = Icons.Default.Screenshot
    ),
    MISSING_CAPTURE_STATE_REDACTION(
        titleSecureRes = R.string.maswe_0038_vector_missing_capture_state_redaction_secure,
        msgSecureRes = R.string.maswe_0038_msg_missing_capture_state_redaction_secure,
        icon = Icons.Default.Videocam
    ),
    EXCESSIVE_ON_SCREEN_DISCLOSURE(
        titleSecureRes = R.string.maswe_0038_vector_excessive_on_screen_disclosure_secure,
        msgSecureRes = R.string.maswe_0038_msg_excessive_on_screen_disclosure_secure,
        icon = Icons.Default.Visibility
    );

    override val masweId = "MASWE-0038"
    override val screenTitleSecureRes = R.string.maswe_0038_secure_title
    override val screenDescSecureRes = R.string.maswe_0038_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0038_secure_vectors_title
}
