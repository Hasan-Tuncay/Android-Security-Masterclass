package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0051Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_HOST_CHECKS(
        titleSecureRes = R.string.maswe_0051_vector_no_host_checks_secure,
        msgSecureRes = R.string.maswe_0051_msg_no_host_checks_secure,
        icon = Icons.Default.DeviceUnknown
    ),
    RELYING_ON_BASIC_DETECTION(
        titleSecureRes = R.string.maswe_0051_vector_relying_on_basic_detection_secure,
        msgSecureRes = R.string.maswe_0051_msg_relying_on_basic_detection_secure,
        icon = Icons.Default.Search
    ),
    RELYING_ON_KNOWN_FILE_PATHS(
        titleSecureRes = R.string.maswe_0051_vector_relying_on_known_file_paths_secure,
        msgSecureRes = R.string.maswe_0051_msg_relying_on_known_file_paths_secure,
        icon = Icons.Default.FolderOpen
    ),
    RELYING_ON_SYSTEM_APIS_ONLY(
        titleSecureRes = R.string.maswe_0051_vector_relying_on_system_apis_only_secure,
        msgSecureRes = R.string.maswe_0051_msg_relying_on_system_apis_only_secure,
        icon = Icons.Default.Api
    ),
    NO_RESPONSE_STRATEGY(
        titleSecureRes = R.string.maswe_0051_vector_no_response_strategy_secure,
        msgSecureRes = R.string.maswe_0051_msg_no_response_strategy_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0051"
    override val screenTitleSecureRes = R.string.maswe_0051_secure_title
    override val screenDescSecureRes = R.string.maswe_0051_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0051_secure_vectors_title
}
