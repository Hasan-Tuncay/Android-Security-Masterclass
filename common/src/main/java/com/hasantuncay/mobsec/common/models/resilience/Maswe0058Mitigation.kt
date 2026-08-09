package com.hasantuncay.mobsec.common.models.resilience

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0058Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_RUNTIME_CODE_CHECKS(
        titleRes = R.string.maswe_0058_vector_no_runtime_code_checks_secure,
        msgRes = R.string.maswe_0058_msg_no_runtime_code_checks_secure,
        icon = Icons.Default.Memory
    ),
    INJECTED_LIBRARIES_NOT_DETECTED(
        titleRes = R.string.maswe_0058_vector_injected_libraries_not_detected_secure,
        msgRes = R.string.maswe_0058_msg_injected_libraries_not_detected_secure,
        icon = Icons.Default.LibraryBooks
    ),
    HOOKED_FUNCTIONS_NOT_DETECTED(
        titleRes = R.string.maswe_0058_vector_hooked_functions_not_detected_secure,
        msgRes = R.string.maswe_0058_msg_hooked_functions_not_detected_secure,
        icon = Icons.Default.Functions
    ),
    NO_RESPONSE_TO_TAMPERING(
        titleRes = R.string.maswe_0058_vector_no_response_to_tampering_secure,
        msgRes = R.string.maswe_0058_msg_no_response_to_tampering_secure,
        icon = Icons.Default.Warning
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0058",
            titleRes = R.string.maswe_0058_secure_title,
            descRes = R.string.maswe_0058_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0058_secure_vectors_title
        )
    }
}
