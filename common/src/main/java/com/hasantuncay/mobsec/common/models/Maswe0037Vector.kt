package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0037Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SENSITIVE_CONTENT_IN_NOTIFICATIONS(
        titleVulnRes = R.string.maswe_0037_vector_sensitive_content_in_notifications_vuln,
        msgVulnRes = R.string.maswe_0037_msg_sensitive_content_in_notifications_vuln,
        icon = Icons.Default.Notifications
    ),
    NO_LOCK_SCREEN_REDACTION(
        titleVulnRes = R.string.maswe_0037_vector_no_lock_screen_redaction_vuln,
        msgVulnRes = R.string.maswe_0037_msg_no_lock_screen_redaction_vuln,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0037"
    override val screenTitleVulnRes = R.string.maswe_0037_vuln_title
    override val screenDescVulnRes = R.string.maswe_0037_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0037_vuln_vectors_title
}
