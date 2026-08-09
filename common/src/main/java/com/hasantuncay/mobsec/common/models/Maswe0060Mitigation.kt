package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0060Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    RESOURCES_LEFT_IN_CLEAR(
        titleSecureRes = R.string.maswe_0060_vector_resources_left_in_clear_secure,
        msgSecureRes = R.string.maswe_0060_msg_resources_left_in_clear_secure,
        icon = Icons.Default.Image
    ),
    IDENTIFIERS_LEFT_MEANINGFUL(
        titleSecureRes = R.string.maswe_0060_vector_identifiers_left_meaningful_secure,
        msgSecureRes = R.string.maswe_0060_msg_identifiers_left_meaningful_secure,
        icon = Icons.Default.TextFormat
    );

    override val masweId = "MASWE-0060"
    override val screenTitleSecureRes = R.string.maswe_0060_secure_title
    override val screenDescSecureRes = R.string.maswe_0060_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0060_secure_vectors_title
}
