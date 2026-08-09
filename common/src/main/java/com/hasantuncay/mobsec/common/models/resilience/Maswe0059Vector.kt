package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0059Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_OBFUSCATION_APPLIED(
        titleRes = R.string.maswe_0059_vector_no_obfuscation_applied_vuln,
        msgRes = R.string.maswe_0059_msg_no_obfuscation_applied_vuln,
        icon = Icons.Default.CodeOff
    ),
    SECURITY_RELEVANT_LOGIC_READABLE(
        titleRes = R.string.maswe_0059_vector_security_relevant_logic_readable_vuln,
        msgRes = R.string.maswe_0059_msg_security_relevant_logic_readable_vuln,
        icon = Icons.Default.Visibility
    ),
    OBFUSCATION_WITHOUT_HARDENING(
        titleRes = R.string.maswe_0059_vector_obfuscation_without_hardening_vuln,
        msgRes = R.string.maswe_0059_msg_obfuscation_without_hardening_vuln,
        icon = Icons.Default.LockOpen
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0059",
            titleRes = R.string.maswe_0059_vuln_title,
            descRes = R.string.maswe_0059_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0059_vuln_vectors_title
        )
    }
}
