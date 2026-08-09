package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0043Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    NO_ENFORCED_UPDATE_MECHANISM(
        titleVulnRes = R.string.maswe_0043_vector_no_enforced_update_mechanism_vuln,
        msgVulnRes = R.string.maswe_0043_msg_no_enforced_update_mechanism_vuln,
        icon = Icons.Default.SystemUpdateAlt
    );

    override val masweId = "MASWE-0043"
    override val screenTitleVulnRes = R.string.maswe_0043_vuln_title
    override val screenDescVulnRes = R.string.maswe_0043_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0043_vuln_vectors_title
}
