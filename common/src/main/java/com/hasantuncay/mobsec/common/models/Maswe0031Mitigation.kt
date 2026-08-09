package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0031Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    ALL_EXTENSION_POINTS_ALLOWED(
        titleSecureRes = R.string.maswe_0031_vector_all_extension_points_allowed_secure,
        msgSecureRes = R.string.maswe_0031_msg_all_extension_points_allowed_secure,
        icon = Icons.Default.Extension
    ),
    THIRD_PARTY_KEYBOARDS_SENSITIVE_INPUT(
        titleSecureRes = R.string.maswe_0031_vector_third_party_keyboards_sensitive_input_secure,
        msgSecureRes = R.string.maswe_0031_msg_third_party_keyboards_sensitive_input_secure,
        icon = Icons.Default.Keyboard
    ),
    SENSITIVE_DATA_HANDED_TO_EXTENSIONS(
        titleSecureRes = R.string.maswe_0031_vector_sensitive_data_handed_to_extensions_secure,
        msgSecureRes = R.string.maswe_0031_msg_sensitive_data_handed_to_extensions_secure,
        icon = Icons.Default.Share
    );

    override val masweId = "MASWE-0031"
    override val screenTitleSecureRes = R.string.maswe_0031_secure_title
    override val screenDescSecureRes = R.string.maswe_0031_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0031_secure_vectors_title
}
