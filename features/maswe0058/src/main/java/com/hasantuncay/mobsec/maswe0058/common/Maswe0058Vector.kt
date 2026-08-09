package com.hasantuncay.mobsec.maswe0058.common

import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Vector
import com.hasantuncay.mobsec.maswe0058.common.Maswe0058Mitigation
import com.hasantuncay.mobsec.maswe0058.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0058Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_RUNTIME_CODE_CHECKS(
        titleRes = R.string.maswe_0058_vector_no_runtime_code_checks_vuln,
        msgRes = R.string.maswe_0058_msg_no_runtime_code_checks_vuln,
        icon = Icons.Default.Memory
    ),
    INJECTED_LIBRARIES_NOT_DETECTED(
        titleRes = R.string.maswe_0058_vector_injected_libraries_not_detected_vuln,
        msgRes = R.string.maswe_0058_msg_injected_libraries_not_detected_vuln,
        icon = Icons.AutoMirrored.Filled.LibraryBooks
    ),
    HOOKED_FUNCTIONS_NOT_DETECTED(
        titleRes = R.string.maswe_0058_vector_hooked_functions_not_detected_vuln,
        msgRes = R.string.maswe_0058_msg_hooked_functions_not_detected_vuln,
        icon = Icons.Default.Functions
    ),
    NO_RESPONSE_TO_TAMPERING(
        titleRes = R.string.maswe_0058_vector_no_response_to_tampering_vuln,
        msgRes = R.string.maswe_0058_msg_no_response_to_tampering_vuln,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0058",
            titleRes = CommonR.string.maswe_0058_vuln_title,
            descRes = CommonR.string.maswe_0058_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0058_vuln_vectors_title
        )
    }
}
