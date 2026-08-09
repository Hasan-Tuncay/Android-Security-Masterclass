package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0058Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_RUNTIME_CODE_CHECKS(
        titleSecureRes = R.string.maswe_0058_vector_no_runtime_code_checks_secure,
        msgSecureRes = R.string.maswe_0058_msg_no_runtime_code_checks_secure,
        icon = Icons.Default.Memory
    ),
    INJECTED_LIBRARIES_NOT_DETECTED(
        titleSecureRes = R.string.maswe_0058_vector_injected_libraries_not_detected_secure,
        msgSecureRes = R.string.maswe_0058_msg_injected_libraries_not_detected_secure,
        icon = Icons.Default.LibraryBooks
    ),
    HOOKED_FUNCTIONS_NOT_DETECTED(
        titleSecureRes = R.string.maswe_0058_vector_hooked_functions_not_detected_secure,
        msgSecureRes = R.string.maswe_0058_msg_hooked_functions_not_detected_secure,
        icon = Icons.Default.Functions
    ),
    NO_RESPONSE_TO_TAMPERING(
        titleSecureRes = R.string.maswe_0058_vector_no_response_to_tampering_secure,
        msgSecureRes = R.string.maswe_0058_msg_no_response_to_tampering_secure,
        icon = Icons.Default.Warning
    );

    override val masweId = "MASWE-0058"
    override val screenTitleSecureRes = R.string.maswe_0058_secure_title
    override val screenDescSecureRes = R.string.maswe_0058_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0058_secure_vectors_title
}
