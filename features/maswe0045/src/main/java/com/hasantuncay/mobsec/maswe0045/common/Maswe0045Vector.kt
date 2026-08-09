package com.hasantuncay.mobsec.maswe0045.common

import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Vector
import com.hasantuncay.mobsec.maswe0045.common.Maswe0045Mitigation
import com.hasantuncay.mobsec.maswe0045.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0045Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    MISSING_STACK_PROTECTION(
        titleRes = R.string.maswe_0045_vector_missing_stack_protection_vuln,
        msgRes = R.string.maswe_0045_msg_missing_stack_protection_vuln,
        icon = Icons.Default.Memory
    ),
    MISSING_PIE_ASLR_SUPPORT(
        titleRes = R.string.maswe_0045_vector_missing_pie_aslr_support_vuln,
        msgRes = R.string.maswe_0045_msg_missing_pie_aslr_support_vuln,
        icon = Icons.Default.Shuffle
    ),
    MISSING_FORTIFIED_FUNCTIONS(
        titleRes = R.string.maswe_0045_vector_missing_fortified_functions_vuln,
        msgRes = R.string.maswe_0045_msg_missing_fortified_functions_vuln,
        icon = Icons.Default.Shield
    ),
    UNSAFE_MEMORY_MANAGEMENT_CHOICES(
        titleRes = R.string.maswe_0045_vector_unsafe_memory_management_choices_vuln,
        msgRes = R.string.maswe_0045_msg_unsafe_memory_management_choices_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0045",
            titleRes = CommonR.string.maswe_0045_vuln_title,
            descRes = CommonR.string.maswe_0045_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0045_vuln_vectors_title
        )
    }
}
