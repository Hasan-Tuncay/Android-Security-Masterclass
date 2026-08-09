package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0051Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_HOST_CHECKS(
        titleRes = R.string.maswe_0051_vector_no_host_checks_vuln,
        msgRes = R.string.maswe_0051_msg_no_host_checks_vuln,
        icon = Icons.Default.DeviceUnknown
    ),
    RELYING_ON_BASIC_DETECTION(
        titleRes = R.string.maswe_0051_vector_relying_on_basic_detection_vuln,
        msgRes = R.string.maswe_0051_msg_relying_on_basic_detection_vuln,
        icon = Icons.Default.Search
    ),
    RELYING_ON_KNOWN_FILE_PATHS(
        titleRes = R.string.maswe_0051_vector_relying_on_known_file_paths_vuln,
        msgRes = R.string.maswe_0051_msg_relying_on_known_file_paths_vuln,
        icon = Icons.Default.FolderOpen
    ),
    RELYING_ON_SYSTEM_APIS_ONLY(
        titleRes = R.string.maswe_0051_vector_relying_on_system_apis_only_vuln,
        msgRes = R.string.maswe_0051_msg_relying_on_system_apis_only_vuln,
        icon = Icons.Default.Api
    ),
    NO_RESPONSE_STRATEGY(
        titleRes = R.string.maswe_0051_vector_no_response_strategy_vuln,
        msgRes = R.string.maswe_0051_msg_no_response_strategy_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0051",
            titleRes = R.string.maswe_0051_vuln_title,
            descRes = R.string.maswe_0051_vuln_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0051_vuln_vectors_title
        )
    }
}
