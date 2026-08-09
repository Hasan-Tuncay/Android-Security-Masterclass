package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0057Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SANDBOX_FILES_NOT_VERIFIED(
        titleSecureRes = R.string.maswe_0057_vector_sandbox_files_not_verified_secure,
        msgSecureRes = R.string.maswe_0057_msg_sandbox_files_not_verified_secure,
        icon = Icons.Default.Folder
    ),
    DOWNLOADED_RESOURCES_NOT_VERIFIED(
        titleSecureRes = R.string.maswe_0057_vector_downloaded_resources_not_verified_secure,
        msgSecureRes = R.string.maswe_0057_msg_downloaded_resources_not_verified_secure,
        icon = Icons.Default.CloudDownload
    ),
    RESTORED_DATA_NOT_REVALIDATED(
        titleSecureRes = R.string.maswe_0057_vector_restored_data_not_revalidated_secure,
        msgSecureRes = R.string.maswe_0057_msg_restored_data_not_revalidated_secure,
        icon = Icons.Default.SettingsBackupRestore
    ),
    VERIFICATION_RESULT_IGNORED(
        titleSecureRes = R.string.maswe_0057_vector_verification_result_ignored_secure,
        msgSecureRes = R.string.maswe_0057_msg_verification_result_ignored_secure,
        icon = Icons.Default.VisibilityOff
    );

    override val masweId = "MASWE-0057"
    override val screenTitleSecureRes = R.string.maswe_0057_secure_title
    override val screenDescSecureRes = R.string.maswe_0057_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0057_secure_vectors_title
}
