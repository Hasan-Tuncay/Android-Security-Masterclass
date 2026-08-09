package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0039Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    TOUCH_FILTERING_NOT_ENABLED(
        titleSecureRes = R.string.maswe_0039_vector_touch_filtering_not_enabled_secure,
        msgSecureRes = R.string.maswe_0039_msg_touch_filtering_not_enabled_secure,
        icon = Icons.Default.TouchApp
    ),
    EXTERNAL_OVERLAYS_NOT_HIDDEN(
        titleSecureRes = R.string.maswe_0039_vector_external_overlays_not_hidden_secure,
        msgSecureRes = R.string.maswe_0039_msg_external_overlays_not_hidden_secure,
        icon = Icons.Default.Layers
    ),
    SENSITIVE_SCREENS_NOT_PROTECTED(
        titleSecureRes = R.string.maswe_0039_vector_sensitive_screens_not_protected_secure,
        msgSecureRes = R.string.maswe_0039_msg_sensitive_screens_not_protected_secure,
        icon = Icons.Default.Security
    );

    override val masweId = "MASWE-0039"
    override val screenTitleSecureRes = R.string.maswe_0039_secure_title
    override val screenDescSecureRes = R.string.maswe_0039_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0039_secure_vectors_title
}
