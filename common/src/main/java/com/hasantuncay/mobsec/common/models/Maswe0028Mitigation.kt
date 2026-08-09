package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

/**
 * MASWE-0028: Insecure Identity Pinning
 */
enum class Maswe0028Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    IMPROPER_PINNING_LIBRARY_CONFIG(
        titleSecureRes = R.string.maswe_0028_vector_improper_pinning_library_config_secure,
        msgSecureRes = R.string.maswe_0028_msg_improper_pinning_library_config_secure,
        icon = Icons.Default.Build
    ),
    DYNAMIC_PINNING_WITHOUT_SECURITY(
        titleSecureRes = R.string.maswe_0028_vector_dynamic_pinning_without_security_secure,
        msgSecureRes = R.string.maswe_0028_msg_dynamic_pinning_without_security_secure,
        icon = Icons.Default.Warning
    ),
    IMPROPER_VALIDATION_LOGIC(
        titleSecureRes = R.string.maswe_0028_vector_improper_validation_logic_secure,
        msgSecureRes = R.string.maswe_0028_msg_improper_validation_logic_secure,
        icon = Icons.Default.BugReport
    ),
    LACK_OF_BACKUP_PINS(
        titleSecureRes = R.string.maswe_0028_vector_lack_of_backup_pins_secure,
        msgSecureRes = R.string.maswe_0028_msg_lack_of_backup_pins_secure,
        icon = Icons.Default.Block
    );

    override val masweId = "MASWE-0028"
    override val screenTitleSecureRes = R.string.maswe_0028_secure_title
    override val screenDescSecureRes = R.string.maswe_0028_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0028_secure_vectors_title
}
