package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0073Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    DATA_COLLECTION_DECL(
        titleVulnRes = R.string.maswe_0073_vector_vuln,
        msgVulnRes = R.string.maswe_0073_msg_vuln,
        icon = Icons.Default.DataUsage
    );

    override val masweId = "MASWE-0073"
    override val screenTitleVulnRes = R.string.maswe_0073_vuln_title
    override val screenDescVulnRes = R.string.maswe_0073_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0073_vuln_vectors_title
}
