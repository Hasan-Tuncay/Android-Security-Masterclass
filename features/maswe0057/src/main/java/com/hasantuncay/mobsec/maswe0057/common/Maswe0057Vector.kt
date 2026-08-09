package com.hasantuncay.mobsec.maswe0057.common

import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Vector
import com.hasantuncay.mobsec.maswe0057.common.Maswe0057Mitigation
import com.hasantuncay.mobsec.maswe0057.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0057Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    SANDBOX_FILES_NOT_VERIFIED(
        titleRes = R.string.maswe_0057_vector_sandbox_files_not_verified_vuln,
        msgRes = R.string.maswe_0057_msg_sandbox_files_not_verified_vuln,
        icon = Icons.Default.Folder
    ),
    DOWNLOADED_RESOURCES_NOT_VERIFIED(
        titleRes = R.string.maswe_0057_vector_downloaded_resources_not_verified_vuln,
        msgRes = R.string.maswe_0057_msg_downloaded_resources_not_verified_vuln,
        icon = Icons.Default.CloudDownload
    ),
    RESTORED_DATA_NOT_REVALIDATED(
        titleRes = R.string.maswe_0057_vector_restored_data_not_revalidated_vuln,
        msgRes = R.string.maswe_0057_msg_restored_data_not_revalidated_vuln,
        icon = Icons.Default.SettingsBackupRestore
    ),
    VERIFICATION_RESULT_IGNORED(
        titleRes = R.string.maswe_0057_vector_verification_result_ignored_vuln,
        msgRes = R.string.maswe_0057_msg_verification_result_ignored_vuln,
        icon = Icons.Default.VisibilityOff
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0057",
            titleRes = CommonR.string.maswe_0057_vuln_title,
            descRes = CommonR.string.maswe_0057_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0057_vuln_vectors_title
        )
    }
}
