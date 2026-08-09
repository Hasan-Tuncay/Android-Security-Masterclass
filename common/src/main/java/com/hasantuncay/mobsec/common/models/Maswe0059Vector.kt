package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0059Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_OBFUSCATION_APPLIED(
        titleVulnRes = R.string.maswe_0059_vector_no_obfuscation_applied_vuln,
        msgVulnRes = R.string.maswe_0059_msg_no_obfuscation_applied_vuln,
        icon = Icons.Default.CodeOff
    ),
    SECURITY_RELEVANT_LOGIC_READABLE(
        titleVulnRes = R.string.maswe_0059_vector_security_relevant_logic_readable_vuln,
        msgVulnRes = R.string.maswe_0059_msg_security_relevant_logic_readable_vuln,
        icon = Icons.Default.Visibility
    ),
    OBFUSCATION_WITHOUT_HARDENING(
        titleVulnRes = R.string.maswe_0059_vector_obfuscation_without_hardening_vuln,
        msgVulnRes = R.string.maswe_0059_msg_obfuscation_without_hardening_vuln,
        icon = Icons.Default.LockOpen
    );

    override val masweId = "MASWE-0059"
    override val screenTitleVulnRes = R.string.maswe_0059_vuln_title
    override val screenDescVulnRes = R.string.maswe_0059_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0059_vuln_vectors_title
}
