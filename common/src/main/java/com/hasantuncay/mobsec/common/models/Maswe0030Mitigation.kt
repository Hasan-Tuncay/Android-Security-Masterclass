package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0030Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SENSITIVE_DATA_COPYABLE(
        titleSecureRes = R.string.maswe_0030_vector_sensitive_data_copyable_secure,
        msgSecureRes = R.string.maswe_0030_msg_sensitive_data_copyable_secure,
        icon = Icons.Default.ContentCopy
    ),
    CLIPBOARD_NOT_MARKED_SENSITIVE(
        titleSecureRes = R.string.maswe_0030_vector_clipboard_not_marked_sensitive_secure,
        msgSecureRes = R.string.maswe_0030_msg_clipboard_not_marked_sensitive_secure,
        icon = Icons.Default.Warning
    ),
    UNIVERSAL_CLIPBOARD_NOT_RESTRICTED(
        titleSecureRes = R.string.maswe_0030_vector_universal_clipboard_not_restricted_secure,
        msgSecureRes = R.string.maswe_0030_msg_universal_clipboard_not_restricted_secure,
        icon = Icons.Default.Public
    ),
    CLIPBOARD_NOT_CLEARED(
        titleSecureRes = R.string.maswe_0030_vector_clipboard_not_cleared_secure,
        msgSecureRes = R.string.maswe_0030_msg_clipboard_not_cleared_secure,
        icon = Icons.Default.Clear
    ),
    UNTRUSTED_CLIPBOARD_INPUT(
        titleSecureRes = R.string.maswe_0030_vector_untrusted_clipboard_input_secure,
        msgSecureRes = R.string.maswe_0030_msg_untrusted_clipboard_input_secure,
        icon = Icons.Default.ContentPaste
    );

    override val masweId = "MASWE-0030"
    override val screenTitleSecureRes = R.string.maswe_0030_secure_title
    override val screenDescSecureRes = R.string.maswe_0030_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0030_secure_vectors_title
}
