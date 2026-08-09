package com.hasantuncay.mobsec.maswe0036.common

import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Vector
import com.hasantuncay.mobsec.maswe0036.common.Maswe0036Mitigation
import com.hasantuncay.mobsec.maswe0036.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0036Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NON_SECURE_TEXT_ENTRY(
        titleRes = R.string.maswe_0036_vector_non_secure_text_entry_secure,
        msgRes = R.string.maswe_0036_msg_non_secure_text_entry_secure,
        icon = Icons.Default.Visibility
    ),
    UNMASKED_SENSITIVE_VALUES(
        titleRes = R.string.maswe_0036_vector_unmasked_sensitive_values_secure,
        msgRes = R.string.maswe_0036_msg_unmasked_sensitive_values_secure,
        icon = Icons.Default.CreditCard
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0036",
            titleRes = CommonR.string.maswe_0036_secure_title,
            descRes = CommonR.string.maswe_0036_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0036_secure_vectors_title
        )
    }
}
