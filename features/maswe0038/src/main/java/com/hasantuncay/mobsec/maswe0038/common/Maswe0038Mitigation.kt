package com.hasantuncay.mobsec.maswe0038.common

import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Vector
import com.hasantuncay.mobsec.maswe0038.common.Maswe0038Mitigation
import com.hasantuncay.mobsec.maswe0038.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0038Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_PLATFORM_SCREENSHOT_PROTECTION(
        titleRes = R.string.maswe_0038_vector_missing_platform_screenshot_protection_secure,
        msgRes = R.string.maswe_0038_msg_missing_platform_screenshot_protection_secure,
        icon = Icons.Default.Screenshot
    ),
    MISSING_CAPTURE_STATE_REDACTION(
        titleRes = R.string.maswe_0038_vector_missing_capture_state_redaction_secure,
        msgRes = R.string.maswe_0038_msg_missing_capture_state_redaction_secure,
        icon = Icons.Default.Videocam
    ),
    EXCESSIVE_ON_SCREEN_DISCLOSURE(
        titleRes = R.string.maswe_0038_vector_excessive_on_screen_disclosure_secure,
        msgRes = R.string.maswe_0038_msg_excessive_on_screen_disclosure_secure,
        icon = Icons.Default.Visibility
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0038",
            titleRes = CommonR.string.maswe_0038_secure_title,
            descRes = CommonR.string.maswe_0038_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0038_secure_vectors_title
        )
    }
}
