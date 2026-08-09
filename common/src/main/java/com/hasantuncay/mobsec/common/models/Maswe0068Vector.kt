package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0068Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    RECENT_APPS_LEAK(
        titleVulnRes = R.string.maswe_0068_vector_vuln,
        msgVulnRes = R.string.maswe_0068_msg_vuln,
        icon = Icons.Default.Visibility
    );

    override val masweId = "MASWE-0068"
    override val screenTitleVulnRes = R.string.maswe_0068_vuln_title
    override val screenDescVulnRes = R.string.maswe_0068_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0068_vuln_vectors_title
}
