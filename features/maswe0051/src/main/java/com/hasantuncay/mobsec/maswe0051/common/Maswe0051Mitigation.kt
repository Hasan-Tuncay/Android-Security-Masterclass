package com.hasantuncay.mobsec.maswe0051.common

import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Vector
import com.hasantuncay.mobsec.maswe0051.common.Maswe0051Mitigation
import com.hasantuncay.mobsec.maswe0051.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0051Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_HOST_CHECKS(
        titleRes = R.string.maswe_0051_vector_no_host_checks_secure,
        msgRes = R.string.maswe_0051_msg_no_host_checks_secure,
        icon = Icons.Default.DeviceUnknown
    ),
    RELYING_ON_BASIC_DETECTION(
        titleRes = R.string.maswe_0051_vector_relying_on_basic_detection_secure,
        msgRes = R.string.maswe_0051_msg_relying_on_basic_detection_secure,
        icon = Icons.Default.Search
    ),
    RELYING_ON_KNOWN_FILE_PATHS(
        titleRes = R.string.maswe_0051_vector_relying_on_known_file_paths_secure,
        msgRes = R.string.maswe_0051_msg_relying_on_known_file_paths_secure,
        icon = Icons.Default.FolderOpen
    ),
    RELYING_ON_SYSTEM_APIS_ONLY(
        titleRes = R.string.maswe_0051_vector_relying_on_system_apis_only_secure,
        msgRes = R.string.maswe_0051_msg_relying_on_system_apis_only_secure,
        icon = Icons.Default.Api
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0051_vector_no_response_strategy_secure,
        msgRes = R.string.maswe_0051_msg_no_response_strategy_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0051",
            titleRes = CommonR.string.maswe_0051_secure_title,
            descRes = CommonR.string.maswe_0051_secure_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0051_secure_vectors_title
        )
    }
}
