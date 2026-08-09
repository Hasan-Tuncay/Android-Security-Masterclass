package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0060Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    RESOURCES_LEFT_IN_CLEAR(
        titleVulnRes = R.string.maswe_0060_vector_resources_left_in_clear_vuln,
        msgVulnRes = R.string.maswe_0060_msg_resources_left_in_clear_vuln,
        icon = Icons.Default.Image
    ),
    IDENTIFIERS_LEFT_MEANINGFUL(
        titleVulnRes = R.string.maswe_0060_vector_identifiers_left_meaningful_vuln,
        msgVulnRes = R.string.maswe_0060_msg_identifiers_left_meaningful_vuln,
        icon = Icons.Default.TextFormat
    );

    override val masweId = "MASWE-0060"
    override val screenTitleVulnRes = R.string.maswe_0060_vuln_title
    override val screenDescVulnRes = R.string.maswe_0060_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0060_vuln_vectors_title
}
