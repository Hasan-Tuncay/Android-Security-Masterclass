package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0068Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RECENT_APPS_LEAK(
        titleSecureRes = R.string.maswe_0068_vector_secure,
        msgSecureRes = R.string.maswe_0068_msg_secure,
        icon = Icons.Default.Visibility
    );

    override val masweId = "MASWE-0068"
    override val screenTitleSecureRes = R.string.maswe_0068_secure_title
    override val screenDescSecureRes = R.string.maswe_0068_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0068_secure_vectors_title
}
