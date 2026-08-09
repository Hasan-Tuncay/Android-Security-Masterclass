package com.hasantuncay.mobsec.common.models.network

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

/**
 * MASWE-0028: Insecure Identity Pinning
 */
enum class Maswe0028Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    IMPROPER_PINNING_LIBRARY_CONFIG(
        titleRes = R.string.maswe_0028_vector_improper_pinning_library_config_secure,
        msgRes = R.string.maswe_0028_msg_improper_pinning_library_config_secure,
        icon = Icons.Default.Build
    ),
    DYNAMIC_PINNING_WITHOUT_SECURITY(
        titleRes = R.string.maswe_0028_vector_dynamic_pinning_without_security_secure,
        msgRes = R.string.maswe_0028_msg_dynamic_pinning_without_security_secure,
        icon = Icons.Default.Warning
    ),
    IMPROPER_VALIDATION_LOGIC(
        titleRes = R.string.maswe_0028_vector_improper_validation_logic_secure,
        msgRes = R.string.maswe_0028_msg_improper_validation_logic_secure,
        icon = Icons.Default.BugReport
    ),
    LACK_OF_BACKUP_PINS(
        titleRes = R.string.maswe_0028_vector_lack_of_backup_pins_secure,
        msgRes = R.string.maswe_0028_msg_lack_of_backup_pins_secure,
        icon = Icons.Default.Block
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0028",
            titleRes = R.string.maswe_0028_secure_title,
            descRes = R.string.maswe_0028_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0028_secure_vectors_title
        )
    }
}
