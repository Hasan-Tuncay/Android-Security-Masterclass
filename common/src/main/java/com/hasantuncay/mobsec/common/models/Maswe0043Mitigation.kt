package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0043Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    NO_ENFORCED_UPDATE_MECHANISM(
        titleSecureRes = R.string.maswe_0043_vector_no_enforced_update_mechanism_secure,
        msgSecureRes = R.string.maswe_0043_msg_no_enforced_update_mechanism_secure,
        icon = Icons.Default.SystemUpdateAlt
    );

    override val masweId = "MASWE-0043"
    override val screenTitleSecureRes = R.string.maswe_0043_secure_title
    override val screenDescSecureRes = R.string.maswe_0043_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0043_secure_vectors_title
}
