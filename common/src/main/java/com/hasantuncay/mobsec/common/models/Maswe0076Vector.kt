package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0076Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DATA_MANAGEMENT(
        titleVulnRes = R.string.maswe_0076_vector_vuln,
        msgVulnRes = R.string.maswe_0076_msg_vuln,
        icon = Icons.Default.Storage
    );

    override val masweId = "MASWE-0076"
    override val screenTitleVulnRes = R.string.maswe_0076_vuln_title
    override val screenDescVulnRes = R.string.maswe_0076_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0076_vuln_vectors_title
}
