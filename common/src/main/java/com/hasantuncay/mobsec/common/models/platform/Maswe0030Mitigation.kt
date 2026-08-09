package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0030Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SENSITIVE_DATA_COPYABLE(
        titleRes = R.string.maswe_0030_vector_sensitive_data_copyable_secure,
        msgRes = R.string.maswe_0030_msg_sensitive_data_copyable_secure,
        icon = Icons.Default.ContentCopy
    ),
    CLIPBOARD_NOT_MARKED_SENSITIVE(
        titleRes = R.string.maswe_0030_vector_clipboard_not_marked_sensitive_secure,
        msgRes = R.string.maswe_0030_msg_clipboard_not_marked_sensitive_secure,
        icon = Icons.Default.Warning
    ),
    UNIVERSAL_CLIPBOARD_NOT_RESTRICTED(
        titleRes = R.string.maswe_0030_vector_universal_clipboard_not_restricted_secure,
        msgRes = R.string.maswe_0030_msg_universal_clipboard_not_restricted_secure,
        icon = Icons.Default.Public
    ),
    CLIPBOARD_NOT_CLEARED(
        titleRes = R.string.maswe_0030_vector_clipboard_not_cleared_secure,
        msgRes = R.string.maswe_0030_msg_clipboard_not_cleared_secure,
        icon = Icons.Default.Clear
    ),
    UNTRUSTED_CLIPBOARD_INPUT(
        titleRes = R.string.maswe_0030_vector_untrusted_clipboard_input_secure,
        msgRes = R.string.maswe_0030_msg_untrusted_clipboard_input_secure,
        icon = Icons.Default.ContentPaste
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0030",
            titleRes = R.string.maswe_0030_secure_title,
            descRes = R.string.maswe_0030_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0030_secure_vectors_title
        )
    }
}
