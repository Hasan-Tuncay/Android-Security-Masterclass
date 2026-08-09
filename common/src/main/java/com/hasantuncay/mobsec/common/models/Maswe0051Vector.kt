package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0051Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_HOST_CHECKS(
        titleVulnRes = R.string.maswe_0051_vector_no_host_checks_vuln,
        msgVulnRes = R.string.maswe_0051_msg_no_host_checks_vuln,
        icon = Icons.Default.DeviceUnknown
    ),
    RELYING_ON_BASIC_DETECTION(
        titleVulnRes = R.string.maswe_0051_vector_relying_on_basic_detection_vuln,
        msgVulnRes = R.string.maswe_0051_msg_relying_on_basic_detection_vuln,
        icon = Icons.Default.Search
    ),
    RELYING_ON_KNOWN_FILE_PATHS(
        titleVulnRes = R.string.maswe_0051_vector_relying_on_known_file_paths_vuln,
        msgVulnRes = R.string.maswe_0051_msg_relying_on_known_file_paths_vuln,
        icon = Icons.Default.FolderOpen
    ),
    RELYING_ON_SYSTEM_APIS_ONLY(
        titleVulnRes = R.string.maswe_0051_vector_relying_on_system_apis_only_vuln,
        msgVulnRes = R.string.maswe_0051_msg_relying_on_system_apis_only_vuln,
        icon = Icons.Default.Api
    ),
    NO_RESPONSE_STRATEGY(
        titleVulnRes = R.string.maswe_0051_vector_no_response_strategy_vuln,
        msgVulnRes = R.string.maswe_0051_msg_no_response_strategy_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0051"
    override val screenTitleVulnRes = R.string.maswe_0051_vuln_title
    override val screenDescVulnRes = R.string.maswe_0051_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0051_vuln_vectors_title
}
