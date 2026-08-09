package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0075Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NON_REPRODUCIBLE(
        titleVulnRes = R.string.maswe_0075_vector_vuln,
        msgVulnRes = R.string.maswe_0075_msg_vuln,
        icon = Icons.Default.Build
    );

    override val masweId = "MASWE-0075"
    override val screenTitleVulnRes = R.string.maswe_0075_vuln_title
    override val screenDescVulnRes = R.string.maswe_0075_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0075_vuln_vectors_title
}
