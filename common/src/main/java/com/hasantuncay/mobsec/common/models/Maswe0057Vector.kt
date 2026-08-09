package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0057Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SANDBOX_FILES_NOT_VERIFIED(
        titleVulnRes = R.string.maswe_0057_vector_sandbox_files_not_verified_vuln,
        msgVulnRes = R.string.maswe_0057_msg_sandbox_files_not_verified_vuln,
        icon = Icons.Default.Folder
    ),
    DOWNLOADED_RESOURCES_NOT_VERIFIED(
        titleVulnRes = R.string.maswe_0057_vector_downloaded_resources_not_verified_vuln,
        msgVulnRes = R.string.maswe_0057_msg_downloaded_resources_not_verified_vuln,
        icon = Icons.Default.CloudDownload
    ),
    RESTORED_DATA_NOT_REVALIDATED(
        titleVulnRes = R.string.maswe_0057_vector_restored_data_not_revalidated_vuln,
        msgVulnRes = R.string.maswe_0057_msg_restored_data_not_revalidated_vuln,
        icon = Icons.Default.SettingsBackupRestore
    ),
    VERIFICATION_RESULT_IGNORED(
        titleVulnRes = R.string.maswe_0057_vector_verification_result_ignored_vuln,
        msgVulnRes = R.string.maswe_0057_msg_verification_result_ignored_vuln,
        icon = Icons.Default.VisibilityOff
    );

    override val masweId = "MASWE-0057"
    override val screenTitleVulnRes = R.string.maswe_0057_vuln_title
    override val screenDescVulnRes = R.string.maswe_0057_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0057_vuln_vectors_title
}
