package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0049Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    LOADING_FROM_WRITABLE_LOCATIONS(
        titleVulnRes = R.string.maswe_0049_vector_loading_from_writable_locations_vuln,
        msgVulnRes = R.string.maswe_0049_msg_loading_from_writable_locations_vuln,
        icon = Icons.Default.FolderSpecial
    ),
    DOWNLOADED_CODE_WITHOUT_VERIFICATION(
        titleVulnRes = R.string.maswe_0049_vector_downloaded_code_without_verification_vuln,
        msgVulnRes = R.string.maswe_0049_msg_downloaded_code_without_verification_vuln,
        icon = Icons.Default.CloudDownload
    ),
    CODE_FROM_OTHER_PACKAGES(
        titleVulnRes = R.string.maswe_0049_vector_code_from_other_packages_vuln,
        msgVulnRes = R.string.maswe_0049_msg_code_from_other_packages_vuln,
        icon = Icons.Default.Apps
    );

    override val masweId = "MASWE-0049"
    override val screenTitleVulnRes = R.string.maswe_0049_vuln_title
    override val screenDescVulnRes = R.string.maswe_0049_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0049_vuln_vectors_title
}
