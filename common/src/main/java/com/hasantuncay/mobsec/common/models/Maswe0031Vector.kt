package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0031Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    ALL_EXTENSION_POINTS_ALLOWED(
        titleVulnRes = R.string.maswe_0031_vector_all_extension_points_allowed_vuln,
        msgVulnRes = R.string.maswe_0031_msg_all_extension_points_allowed_vuln,
        icon = Icons.Default.Extension
    ),
    THIRD_PARTY_KEYBOARDS_SENSITIVE_INPUT(
        titleVulnRes = R.string.maswe_0031_vector_third_party_keyboards_sensitive_input_vuln,
        msgVulnRes = R.string.maswe_0031_msg_third_party_keyboards_sensitive_input_vuln,
        icon = Icons.Default.Keyboard
    ),
    SENSITIVE_DATA_HANDED_TO_EXTENSIONS(
        titleVulnRes = R.string.maswe_0031_vector_sensitive_data_handed_to_extensions_vuln,
        msgVulnRes = R.string.maswe_0031_msg_sensitive_data_handed_to_extensions_vuln,
        icon = Icons.Default.Share
    );

    override val masweId = "MASWE-0031"
    override val screenTitleVulnRes = R.string.maswe_0031_vuln_title
    override val screenDescVulnRes = R.string.maswe_0031_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0031_vuln_vectors_title
}
