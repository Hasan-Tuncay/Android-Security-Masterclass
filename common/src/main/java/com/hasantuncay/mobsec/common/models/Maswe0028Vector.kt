package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0028: Insecure Identity Pinning
 */
enum class Maswe0028Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    IMPROPER_PINNING_LIBRARY_CONFIG(
        titleVulnRes = R.string.maswe_0028_vector_improper_pinning_library_config_vuln,
        msgVulnRes = R.string.maswe_0028_msg_improper_pinning_library_config_vuln,
        icon = Icons.Default.Build
    ),
    DYNAMIC_PINNING_WITHOUT_SECURITY(
        titleVulnRes = R.string.maswe_0028_vector_dynamic_pinning_without_security_vuln,
        msgVulnRes = R.string.maswe_0028_msg_dynamic_pinning_without_security_vuln,
        icon = Icons.Default.Warning
    ),
    IMPROPER_VALIDATION_LOGIC(
        titleVulnRes = R.string.maswe_0028_vector_improper_validation_logic_vuln,
        msgVulnRes = R.string.maswe_0028_msg_improper_validation_logic_vuln,
        icon = Icons.Default.BugReport
    ),
    LACK_OF_BACKUP_PINS(
        titleVulnRes = R.string.maswe_0028_vector_lack_of_backup_pins_vuln,
        msgVulnRes = R.string.maswe_0028_msg_lack_of_backup_pins_vuln,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0028"
    override val screenTitleVulnRes = R.string.maswe_0028_vuln_title
    override val screenDescVulnRes = R.string.maswe_0028_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0028_vuln_vectors_title
}
