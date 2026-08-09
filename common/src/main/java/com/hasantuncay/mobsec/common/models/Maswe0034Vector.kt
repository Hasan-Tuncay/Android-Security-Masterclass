package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0034Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    FILE_ACCESS_ENABLED(
        titleVulnRes = R.string.maswe_0034_vector_file_access_enabled_vuln,
        msgVulnRes = R.string.maswe_0034_msg_file_access_enabled_vuln,
        icon = Icons.Default.FolderShared
    ),
    UNIVERSAL_ACCESS_FROM_FILE_URLS(
        titleVulnRes = R.string.maswe_0034_vector_universal_access_from_file_urls_vuln,
        msgVulnRes = R.string.maswe_0034_msg_universal_access_from_file_urls_vuln,
        icon = Icons.Default.Public
    ),
    INSECURE_CUSTOM_RESOURCE_LOADING(
        titleVulnRes = R.string.maswe_0034_vector_insecure_custom_resource_loading_vuln,
        msgVulnRes = R.string.maswe_0034_msg_insecure_custom_resource_loading_vuln,
        icon = Icons.Default.Build
    ),
    OVERLY_BROAD_FILE_READ_GRANTS(
        titleVulnRes = R.string.maswe_0034_vector_overly_broad_file_read_grants_vuln,
        msgVulnRes = R.string.maswe_0034_msg_overly_broad_file_read_grants_vuln,
        icon = Icons.Default.FolderOpen
    );

    override val masweId = "MASWE-0034"
    override val screenTitleVulnRes = R.string.maswe_0034_vuln_title
    override val screenDescVulnRes = R.string.maswe_0034_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0034_vuln_vectors_title
}
