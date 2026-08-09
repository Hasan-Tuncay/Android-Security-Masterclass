package com.hasantuncay.mobsec.maswe0031.common

import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Vector
import com.hasantuncay.mobsec.maswe0031.common.Maswe0031Mitigation
import com.hasantuncay.mobsec.maswe0031.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.models.MasweVector
import com.hasantuncay.mobsec.common.models.MasweScreenMeta

enum class Maswe0031Vector(
    @StringRes override val titleRes: Int,
    @StringRes override val msgRes: Int,
    override val icon: ImageVector
) : MasweVector {
    ALL_EXTENSION_POINTS_ALLOWED(
        titleRes = R.string.maswe_0031_vector_all_extension_points_allowed_vuln,
        msgRes = R.string.maswe_0031_msg_all_extension_points_allowed_vuln,
        icon = Icons.Default.Extension
    ),
    THIRD_PARTY_KEYBOARDS_SENSITIVE_INPUT(
        titleRes = R.string.maswe_0031_vector_third_party_keyboards_sensitive_input_vuln,
        msgRes = R.string.maswe_0031_msg_third_party_keyboards_sensitive_input_vuln,
        icon = Icons.Default.Keyboard
    ),
    SENSITIVE_DATA_HANDED_TO_EXTENSIONS(
        titleRes = R.string.maswe_0031_vector_sensitive_data_handed_to_extensions_vuln,
        msgRes = R.string.maswe_0031_msg_sensitive_data_handed_to_extensions_vuln,
        icon = Icons.Default.Share
    );

    companion object {
        val meta = MasweScreenMeta(
            masweId = "MASWE-0031",
            titleRes = CommonR.string.maswe_0031_vuln_title,
            descRes = CommonR.string.maswe_0031_vuln_desc,
            contextInfoRes = CommonR.string.maswe_context_info,
            itemsTitleRes = CommonR.string.maswe_0031_vuln_vectors_title
        )
    }
}
