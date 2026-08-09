package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0036Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NON_SECURE_TEXT_ENTRY(
        titleSecureRes = R.string.maswe_0036_vector_non_secure_text_entry_secure,
        msgSecureRes = R.string.maswe_0036_msg_non_secure_text_entry_secure,
        icon = Icons.Default.Visibility
    ),
    UNMASKED_SENSITIVE_VALUES(
        titleSecureRes = R.string.maswe_0036_vector_unmasked_sensitive_values_secure,
        msgSecureRes = R.string.maswe_0036_msg_unmasked_sensitive_values_secure,
        icon = Icons.Default.CreditCard
    );

    override val masweId = "MASWE-0036"
    override val screenTitleSecureRes = R.string.maswe_0036_secure_title
    override val screenDescSecureRes = R.string.maswe_0036_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0036_secure_vectors_title
}
