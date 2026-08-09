package com.hasantuncay.mobsec.maswe0037.common

import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Vector
import com.hasantuncay.mobsec.maswe0037.common.Maswe0037Mitigation
import com.hasantuncay.mobsec.maswe0037.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0037Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SENSITIVE_CONTENT_IN_NOTIFICATIONS(
        titleRes = R.string.maswe_0037_vector_sensitive_content_in_notifications_vuln,
        msgRes = R.string.maswe_0037_msg_sensitive_content_in_notifications_vuln,
        icon = Icons.Default.Notifications
    ),
    NO_LOCK_SCREEN_REDACTION(
        titleRes = R.string.maswe_0037_vector_no_lock_screen_redaction_vuln,
        msgRes = R.string.maswe_0037_msg_no_lock_screen_redaction_vuln,
        icon = Icons.Default.LockOpen
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0037",
            titleRes = CommonR.string.maswe_0037_vuln_title,
            descRes = CommonR.string.maswe_0037_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0037_vuln_vectors_title
        )
    }
}
