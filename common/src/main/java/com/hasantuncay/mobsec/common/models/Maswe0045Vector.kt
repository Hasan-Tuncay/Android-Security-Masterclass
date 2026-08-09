package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0045Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISSING_STACK_PROTECTION(
        titleVulnRes = R.string.maswe_0045_vector_missing_stack_protection_vuln,
        msgVulnRes = R.string.maswe_0045_msg_missing_stack_protection_vuln,
        icon = Icons.Default.Memory
    ),
    MISSING_PIE_ASLR_SUPPORT(
        titleVulnRes = R.string.maswe_0045_vector_missing_pie_aslr_support_vuln,
        msgVulnRes = R.string.maswe_0045_msg_missing_pie_aslr_support_vuln,
        icon = Icons.Default.Shuffle
    ),
    MISSING_FORTIFIED_FUNCTIONS(
        titleVulnRes = R.string.maswe_0045_vector_missing_fortified_functions_vuln,
        msgVulnRes = R.string.maswe_0045_msg_missing_fortified_functions_vuln,
        icon = Icons.Default.Shield
    ),
    UNSAFE_MEMORY_MANAGEMENT_CHOICES(
        titleVulnRes = R.string.maswe_0045_vector_unsafe_memory_management_choices_vuln,
        msgVulnRes = R.string.maswe_0045_msg_unsafe_memory_management_choices_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0045"
    override val screenTitleVulnRes = R.string.maswe_0045_vuln_title
    override val screenDescVulnRes = R.string.maswe_0045_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0045_vuln_vectors_title
}
