package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0040Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SECRETS_IN_ACCESSIBILITY_METADATA(
        titleVulnRes = R.string.maswe_0040_vector_secrets_in_accessibility_metadata_vuln,
        msgVulnRes = R.string.maswe_0040_msg_secrets_in_accessibility_metadata_vuln,
        icon = Icons.Default.Accessibility
    ),
    SENSITIVE_FIELDS_NOT_SECURE_INPUT(
        titleVulnRes = R.string.maswe_0040_vector_sensitive_fields_not_secure_input_vuln,
        msgVulnRes = R.string.maswe_0040_msg_sensitive_fields_not_secure_input_vuln,
        icon = Icons.Default.Visibility
    ),
    HIGH_RISK_FLOWS_AUTOMATABLE(
        titleVulnRes = R.string.maswe_0040_vector_high_risk_flows_automatable_vuln,
        msgVulnRes = R.string.maswe_0040_msg_high_risk_flows_automatable_vuln,
        icon = Icons.Default.AutoMode
    ),
    SYSTEM_KEYBOARDS_EXPOSING_INPUT(
        titleVulnRes = R.string.maswe_0040_vector_system_keyboards_exposing_input_vuln,
        msgVulnRes = R.string.maswe_0040_msg_system_keyboards_exposing_input_vuln,
        icon = Icons.Default.Keyboard
    );

    override val masweId = "MASWE-0040"
    override val screenTitleVulnRes = R.string.maswe_0040_vuln_title
    override val screenDescVulnRes = R.string.maswe_0040_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0040_vuln_vectors_title
}
