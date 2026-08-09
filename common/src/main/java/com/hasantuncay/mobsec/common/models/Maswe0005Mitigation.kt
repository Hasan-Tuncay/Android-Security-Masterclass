package com.hasantuncay.mobsec.common.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NetworkWifi
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.R

enum class Maswe0005Mitigation(
    @StringRes override val titleSecureRes: Int,
    @StringRes override val msgSecureRes: Int,
    override val icon: ImageVector
) : MasweMitigation {
    SYSTEM_CONSOLE(
        titleSecureRes = R.string.maswe_0005_vector_sys_console_secure,
        msgSecureRes = R.string.maswe_0005_msg_sys_console_secure,
        icon = Icons.Default.Terminal
    ),
    NETWORK_INTERCEPTOR(
        titleSecureRes = R.string.maswe_0005_vector_network_secure,
        msgSecureRes = R.string.maswe_0005_msg_network_secure,
        icon = Icons.Default.NetworkWifi
    ),
    LOCAL_FILE(
        titleSecureRes = R.string.maswe_0005_vector_local_file_secure,
        msgSecureRes = R.string.maswe_0005_msg_local_file_secure,
        icon = Icons.Default.Save
    ),
    SDK_TELEMETRY(
        titleSecureRes = R.string.maswe_0005_vector_sdk_secure,
        msgSecureRes = R.string.maswe_0005_msg_sdk_secure,
        icon = Icons.Default.BugReport
    ),
    WEBVIEW_CONSOLE(
        titleSecureRes = R.string.maswe_0005_vector_webview_secure,
        msgSecureRes = R.string.maswe_0005_msg_webview_secure,
        icon = Icons.Default.Language
    );

    override val masweId = "MASWE-0005"
    override val screenTitleSecureRes = R.string.maswe_0005_secure_title
    override val screenDescSecureRes = R.string.maswe_0005_secure_desc
    override val contextInfoRes = R.string.maswe_context_info
    override val vectorsTitleSecureRes = R.string.maswe_0005_secure_vectors_title
}
