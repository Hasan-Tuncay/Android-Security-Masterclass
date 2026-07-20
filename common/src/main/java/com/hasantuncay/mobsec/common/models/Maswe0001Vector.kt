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

enum class Maswe0001Vector(
    @StringRes val titleVulnRes: Int,
    @StringRes val titleSecureRes: Int,
    @StringRes val msgVulnRes: Int,
    @StringRes val msgSecureRes: Int,
    val icon: ImageVector
) {
    SYSTEM_CONSOLE(
        titleVulnRes = R.string.maswe_0001_vector_sys_console_vuln,
        titleSecureRes = R.string.maswe_0001_vector_sys_console_secure,
        msgVulnRes = R.string.maswe_0001_msg_sys_console_vuln,
        msgSecureRes = R.string.maswe_0001_msg_sys_console_secure,
        icon = Icons.Default.Terminal
    ),
    NETWORK_INTERCEPTOR(
        titleVulnRes = R.string.maswe_0001_vector_network_vuln,
        titleSecureRes = R.string.maswe_0001_vector_network_secure,
        msgVulnRes = R.string.maswe_0001_msg_network_vuln,
        msgSecureRes = R.string.maswe_0001_msg_network_secure,
        icon = Icons.Default.NetworkWifi
    ),
    LOCAL_FILE(
        titleVulnRes = R.string.maswe_0001_vector_local_file_vuln,
        titleSecureRes = R.string.maswe_0001_vector_local_file_secure,
        msgVulnRes = R.string.maswe_0001_msg_local_file_vuln,
        msgSecureRes = R.string.maswe_0001_msg_local_file_secure,
        icon = Icons.Default.Save
    ),
    SDK_TELEMETRY(
        titleVulnRes = R.string.maswe_0001_vector_sdk_vuln,
        titleSecureRes = R.string.maswe_0001_vector_sdk_secure,
        msgVulnRes = R.string.maswe_0001_msg_sdk_vuln,
        msgSecureRes = R.string.maswe_0001_msg_sdk_secure,
        icon = Icons.Default.BugReport
    ),
    WEBVIEW_CONSOLE(
        titleVulnRes = R.string.maswe_0001_vector_webview_vuln,
        titleSecureRes = R.string.maswe_0001_vector_webview_secure,
        msgVulnRes = R.string.maswe_0001_msg_webview_vuln,
        msgSecureRes = R.string.maswe_0001_msg_webview_secure,
        icon = Icons.Default.Language
    )
}
