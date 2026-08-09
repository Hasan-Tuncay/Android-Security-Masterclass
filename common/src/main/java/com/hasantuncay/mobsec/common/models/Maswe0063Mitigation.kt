package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0063Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    MISCONFIGURED_BUILD_SETTINGS(
        titleSecureRes = R.string.maswe_0063_vector_misconfigured_build_settings_secure,
        msgSecureRes = R.string.maswe_0063_msg_misconfigured_build_settings_secure,
        icon = Icons.Default.BuildCircle
    ),
    WEBVIEW_DEBUGGING_ENABLED(
        titleSecureRes = R.string.maswe_0063_vector_webview_debugging_enabled_secure,
        msgSecureRes = R.string.maswe_0063_msg_webview_debugging_enabled_secure,
        icon = Icons.Default.Javascript
    );

    override val masweId = "MASWE-0063"
    override val screenTitleSecureRes = R.string.maswe_0063_secure_title
    override val screenDescSecureRes = R.string.maswe_0063_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0063_secure_vectors_title
}
