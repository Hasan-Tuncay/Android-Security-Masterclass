package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0037Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SENSITIVE_CONTENT_IN_NOTIFICATIONS(
        titleSecureRes = R.string.maswe_0037_vector_sensitive_content_in_notifications_secure,
        msgSecureRes = R.string.maswe_0037_msg_sensitive_content_in_notifications_secure,
        icon = Icons.Default.Notifications
    ),
    NO_LOCK_SCREEN_REDACTION(
        titleSecureRes = R.string.maswe_0037_vector_no_lock_screen_redaction_secure,
        msgSecureRes = R.string.maswe_0037_msg_no_lock_screen_redaction_secure,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0037"
    override val screenTitleSecureRes = R.string.maswe_0037_secure_title
    override val screenDescSecureRes = R.string.maswe_0037_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0037_secure_vectors_title
}
