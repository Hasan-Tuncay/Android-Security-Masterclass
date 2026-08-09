package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0058Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_RUNTIME_CODE_CHECKS(
        titleVulnRes = R.string.maswe_0058_vector_no_runtime_code_checks_vuln,
        msgVulnRes = R.string.maswe_0058_msg_no_runtime_code_checks_vuln,
        icon = Icons.Default.Memory
    ),
    INJECTED_LIBRARIES_NOT_DETECTED(
        titleVulnRes = R.string.maswe_0058_vector_injected_libraries_not_detected_vuln,
        msgVulnRes = R.string.maswe_0058_msg_injected_libraries_not_detected_vuln,
        icon = Icons.Default.LibraryBooks
    ),
    HOOKED_FUNCTIONS_NOT_DETECTED(
        titleVulnRes = R.string.maswe_0058_vector_hooked_functions_not_detected_vuln,
        msgVulnRes = R.string.maswe_0058_msg_hooked_functions_not_detected_vuln,
        icon = Icons.Default.Functions
    ),
    NO_RESPONSE_TO_TAMPERING(
        titleVulnRes = R.string.maswe_0058_vector_no_response_to_tampering_vuln,
        msgVulnRes = R.string.maswe_0058_msg_no_response_to_tampering_vuln,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0058"
    override val screenTitleVulnRes = R.string.maswe_0058_vuln_title
    override val screenDescVulnRes = R.string.maswe_0058_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0058_vuln_vectors_title
}
