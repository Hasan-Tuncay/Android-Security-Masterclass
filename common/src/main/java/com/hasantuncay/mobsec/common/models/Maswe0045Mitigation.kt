package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0045Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISSING_STACK_PROTECTION(
        titleSecureRes = R.string.maswe_0045_vector_missing_stack_protection_secure,
        msgSecureRes = R.string.maswe_0045_msg_missing_stack_protection_secure,
        icon = Icons.Default.Memory
    ),
    MISSING_PIE_ASLR_SUPPORT(
        titleSecureRes = R.string.maswe_0045_vector_missing_pie_aslr_support_secure,
        msgSecureRes = R.string.maswe_0045_msg_missing_pie_aslr_support_secure,
        icon = Icons.Default.Shuffle
    ),
    MISSING_FORTIFIED_FUNCTIONS(
        titleSecureRes = R.string.maswe_0045_vector_missing_fortified_functions_secure,
        msgSecureRes = R.string.maswe_0045_msg_missing_fortified_functions_secure,
        icon = Icons.Default.Shield
    ),
    UNSAFE_MEMORY_MANAGEMENT_CHOICES(
        titleSecureRes = R.string.maswe_0045_vector_unsafe_memory_management_choices_secure,
        msgSecureRes = R.string.maswe_0045_msg_unsafe_memory_management_choices_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0045"
    override val screenTitleSecureRes = R.string.maswe_0045_secure_title
    override val screenDescSecureRes = R.string.maswe_0045_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0045_secure_vectors_title
}
