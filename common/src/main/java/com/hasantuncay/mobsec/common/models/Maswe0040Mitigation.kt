package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0040Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SECRETS_IN_ACCESSIBILITY_METADATA(
        titleSecureRes = R.string.maswe_0040_vector_secrets_in_accessibility_metadata_secure,
        msgSecureRes = R.string.maswe_0040_msg_secrets_in_accessibility_metadata_secure,
        icon = Icons.Default.Accessibility
    ),
    SENSITIVE_FIELDS_NOT_SECURE_INPUT(
        titleSecureRes = R.string.maswe_0040_vector_sensitive_fields_not_secure_input_secure,
        msgSecureRes = R.string.maswe_0040_msg_sensitive_fields_not_secure_input_secure,
        icon = Icons.Default.Visibility
    ),
    HIGH_RISK_FLOWS_AUTOMATABLE(
        titleSecureRes = R.string.maswe_0040_vector_high_risk_flows_automatable_secure,
        msgSecureRes = R.string.maswe_0040_msg_high_risk_flows_automatable_secure,
        icon = Icons.Default.AutoMode
    ),
    SYSTEM_KEYBOARDS_EXPOSING_INPUT(
        titleSecureRes = R.string.maswe_0040_vector_system_keyboards_exposing_input_secure,
        msgSecureRes = R.string.maswe_0040_msg_system_keyboards_exposing_input_secure,
        icon = Icons.Default.Keyboard
    );

    override val masweId = "MASWE-0040"
    override val screenTitleSecureRes = R.string.maswe_0040_secure_title
    override val screenDescSecureRes = R.string.maswe_0040_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0040_secure_vectors_title
}
