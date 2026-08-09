package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0067Vector(
    @StringRes override val titleVulnRes: Int,
    @StringRes override val msgVulnRes: Int,
    override val icon: ImageVector
) : MasweVector {
    CUSTOM_KEYBOARD(
        titleVulnRes = R.string.maswe_0067_vector_vuln,
        msgVulnRes = R.string.maswe_0067_msg_vuln,
        icon = Icons.Default.Keyboard
    );

    override val masweId = "MASWE-0067"
    override val screenTitleVulnRes = R.string.maswe_0067_vuln_title
    override val screenDescVulnRes = R.string.maswe_0067_vuln_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleVulnRes = R.string.maswe_0067_vuln_vectors_title
}
