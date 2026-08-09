package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0076Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    DATA_MANAGEMENT(
        titleSecureRes = R.string.maswe_0076_vector_secure,
        msgSecureRes = R.string.maswe_0076_msg_secure,
        icon = Icons.Default.Storage
    );

    override val masweId = "MASWE-0076"
    override val screenTitleSecureRes = R.string.maswe_0076_secure_title
    override val screenDescSecureRes = R.string.maswe_0076_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0076_secure_vectors_title
}
