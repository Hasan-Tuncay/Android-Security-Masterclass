package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0030Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SENSITIVE_DATA_COPYABLE(
        titleVulnRes = R.string.maswe_0030_vector_sensitive_data_copyable_vuln,
        msgVulnRes = R.string.maswe_0030_msg_sensitive_data_copyable_vuln,
        icon = Icons.Default.ContentCopy
    ),
    CLIPBOARD_NOT_MARKED_SENSITIVE(
        titleVulnRes = R.string.maswe_0030_vector_clipboard_not_marked_sensitive_vuln,
        msgVulnRes = R.string.maswe_0030_msg_clipboard_not_marked_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    UNIVERSAL_CLIPBOARD_NOT_RESTRICTED(
        titleVulnRes = R.string.maswe_0030_vector_universal_clipboard_not_restricted_vuln,
        msgVulnRes = R.string.maswe_0030_msg_universal_clipboard_not_restricted_vuln,
        icon = Icons.Default.Public
    ),
    CLIPBOARD_NOT_CLEARED(
        titleVulnRes = R.string.maswe_0030_vector_clipboard_not_cleared_vuln,
        msgVulnRes = R.string.maswe_0030_msg_clipboard_not_cleared_vuln,
        icon = Icons.Default.Clear
    ),
    UNTRUSTED_CLIPBOARD_INPUT(
        titleVulnRes = R.string.maswe_0030_vector_untrusted_clipboard_input_vuln,
        msgVulnRes = R.string.maswe_0030_msg_untrusted_clipboard_input_vuln,
        icon = Icons.Default.ContentPaste
    );

    override val masweId = "MASWE-0030"
    override val screenTitleVulnRes = R.string.maswe_0030_vuln_title
    override val screenDescVulnRes = R.string.maswe_0030_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0030_vuln_vectors_title
}
