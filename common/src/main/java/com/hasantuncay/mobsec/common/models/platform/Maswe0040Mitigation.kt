package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0040Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SECRETS_IN_ACCESSIBILITY_METADATA(
        titleRes = R.string.maswe_0040_vector_secrets_in_accessibility_metadata_secure,
        msgRes = R.string.maswe_0040_msg_secrets_in_accessibility_metadata_secure,
        icon = Icons.Default.Accessibility
    ),
    SENSITIVE_FIELDS_NOT_SECURE_INPUT(
        titleRes = R.string.maswe_0040_vector_sensitive_fields_not_secure_input_secure,
        msgRes = R.string.maswe_0040_msg_sensitive_fields_not_secure_input_secure,
        icon = Icons.Default.Visibility
    ),
    HIGH_RISK_FLOWS_AUTOMATABLE(
        titleRes = R.string.maswe_0040_vector_high_risk_flows_automatable_secure,
        msgRes = R.string.maswe_0040_msg_high_risk_flows_automatable_secure,
        icon = Icons.Default.AutoMode
    ),
    SYSTEM_KEYBOARDS_EXPOSING_INPUT(
        titleRes = R.string.maswe_0040_vector_system_keyboards_exposing_input_secure,
        msgRes = R.string.maswe_0040_msg_system_keyboards_exposing_input_secure,
        icon = Icons.Default.Keyboard
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0040",
            titleRes = R.string.maswe_0040_secure_title,
            descRes = R.string.maswe_0040_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0040_secure_vectors_title
        )
    }
}
