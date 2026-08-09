package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0037Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SENSITIVE_CONTENT_IN_NOTIFICATIONS(
        titleRes = R.string.maswe_0037_vector_sensitive_content_in_notifications_secure,
        msgRes = R.string.maswe_0037_msg_sensitive_content_in_notifications_secure,
        icon = Icons.Default.Notifications
    ),
    NO_LOCK_SCREEN_REDACTION(
        titleRes = R.string.maswe_0037_vector_no_lock_screen_redaction_secure,
        msgRes = R.string.maswe_0037_msg_no_lock_screen_redaction_secure,
        icon = Icons.Default.LockOpen
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0037",
            titleRes = R.string.maswe_0037_secure_title,
            descRes = R.string.maswe_0037_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0037_secure_vectors_title
        )
    }
}
