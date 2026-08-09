package com.hasantuncay.mobsec.common.models.code

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0045Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_STACK_PROTECTION(
        titleRes = R.string.maswe_0045_vector_missing_stack_protection_secure,
        msgRes = R.string.maswe_0045_msg_missing_stack_protection_secure,
        icon = Icons.Default.Memory
    ),
    MISSING_PIE_ASLR_SUPPORT(
        titleRes = R.string.maswe_0045_vector_missing_pie_aslr_support_secure,
        msgRes = R.string.maswe_0045_msg_missing_pie_aslr_support_secure,
        icon = Icons.Default.Shuffle
    ),
    MISSING_FORTIFIED_FUNCTIONS(
        titleRes = R.string.maswe_0045_vector_missing_fortified_functions_secure,
        msgRes = R.string.maswe_0045_msg_missing_fortified_functions_secure,
        icon = Icons.Default.Shield
    ),
    UNSAFE_MEMORY_MANAGEMENT_CHOICES(
        titleRes = R.string.maswe_0045_vector_unsafe_memory_management_choices_secure,
        msgRes = R.string.maswe_0045_msg_unsafe_memory_management_choices_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0045",
            titleRes = R.string.maswe_0045_secure_title,
            descRes = R.string.maswe_0045_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0045_secure_vectors_title
        )
    }
}
