package com.hasantuncay.mobsec.maswe0030.common

import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Vector
import com.hasantuncay.mobsec.maswe0030.common.Maswe0030Mitigation
import com.hasantuncay.mobsec.maswe0030.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0030Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SENSITIVE_DATA_COPYABLE(
        titleRes = R.string.maswe_0030_vector_sensitive_data_copyable_vuln,
        msgRes = R.string.maswe_0030_msg_sensitive_data_copyable_vuln,
        icon = Icons.Default.ContentCopy
    ),
    CLIPBOARD_NOT_MARKED_SENSITIVE(
        titleRes = R.string.maswe_0030_vector_clipboard_not_marked_sensitive_vuln,
        msgRes = R.string.maswe_0030_msg_clipboard_not_marked_sensitive_vuln,
        icon = Icons.Default.Warning
    ),
    UNIVERSAL_CLIPBOARD_NOT_RESTRICTED(
        titleRes = R.string.maswe_0030_vector_universal_clipboard_not_restricted_vuln,
        msgRes = R.string.maswe_0030_msg_universal_clipboard_not_restricted_vuln,
        icon = Icons.Default.Public
    ),
    CLIPBOARD_NOT_CLEARED(
        titleRes = R.string.maswe_0030_vector_clipboard_not_cleared_vuln,
        msgRes = R.string.maswe_0030_msg_clipboard_not_cleared_vuln,
        icon = Icons.Default.Clear
    ),
    UNTRUSTED_CLIPBOARD_INPUT(
        titleRes = R.string.maswe_0030_vector_untrusted_clipboard_input_vuln,
        msgRes = R.string.maswe_0030_msg_untrusted_clipboard_input_vuln,
        icon = Icons.Default.ContentPaste
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0030",
            titleRes = CommonR.string.maswe_0030_vuln_title,
            descRes = CommonR.string.maswe_0030_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0030_vuln_vectors_title
        )
    }
}
