package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0036Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NON_SECURE_TEXT_ENTRY(
        titleVulnRes = R.string.maswe_0036_vector_non_secure_text_entry_vuln,
        msgVulnRes = R.string.maswe_0036_msg_non_secure_text_entry_vuln,
        icon = Icons.Default.Visibility
    ),
    UNMASKED_SENSITIVE_VALUES(
        titleVulnRes = R.string.maswe_0036_vector_unmasked_sensitive_values_vuln,
        msgVulnRes = R.string.maswe_0036_msg_unmasked_sensitive_values_vuln,
        icon = Icons.Default.CreditCard
    );

    override val masweId = "MASWE-0036"
    override val screenTitleVulnRes = R.string.maswe_0036_vuln_title
    override val screenDescVulnRes = R.string.maswe_0036_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0036_vuln_vectors_title
}
