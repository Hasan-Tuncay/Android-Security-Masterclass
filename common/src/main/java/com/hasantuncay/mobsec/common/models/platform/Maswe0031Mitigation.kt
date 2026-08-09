package com.hasantuncay.mobsec.common.models.platform

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.MasweMitigation
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0031Mitigation(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    ALL_EXTENSION_POINTS_ALLOWED(
        titleRes = R.string.maswe_0031_vector_all_extension_points_allowed_secure,
        msgRes = R.string.maswe_0031_msg_all_extension_points_allowed_secure,
        icon = Icons.Default.Extension
    ),
    THIRD_PARTY_KEYBOARDS_SENSITIVE_INPUT(
        titleRes = R.string.maswe_0031_vector_third_party_keyboards_sensitive_input_secure,
        msgRes = R.string.maswe_0031_msg_third_party_keyboards_sensitive_input_secure,
        icon = Icons.Default.Keyboard
    ),
    SENSITIVE_DATA_HANDED_TO_EXTENSIONS(
        titleRes = R.string.maswe_0031_vector_sensitive_data_handed_to_extensions_secure,
        msgRes = R.string.maswe_0031_msg_sensitive_data_handed_to_extensions_secure,
        icon = Icons.Default.Share
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0031",
            titleRes = R.string.maswe_0031_secure_title,
            descRes = R.string.maswe_0031_secure_desc,
            contextInfoRes = R.string.maswe_context_info,
            itemsTitleRes = R.string.maswe_0031_secure_vectors_title
        )
    }
}
